package com.family.circle.api.websocket;

import com.alibaba.fastjson.JSON;
import com.family.circle.api.entity.ChatContentInfo;
import com.family.circle.api.service.ChatContentInfoService;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@ServerEndpoint(path = "${ws.server.path}",
        host = "${ws.server.host}",
        port = "${ws.server.port}",
        bossLoopGroupThreads = "${ws.thread.boss}",
        workerLoopGroupThreads = "${ws.thread.worker}")
@Slf4j
@Component
public class ChatWebSocket {

    @Autowired
    private ChatContentInfoService chatContentInfoService;

    /**
     * 当有新的连接进入时，对该方法进行回调
     *
     * @param session
     * @param headers
     * @param req
     * @param reqMap
     * @param arg
     * @param pathMap
     */
    @BeforeHandshake
    public void handshake(Session session, HttpHeaders headers, @RequestParam String req, @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap) {
        log.info("begin to connect， req： {} arg:{}.", req, arg);
        session.setSubprotocols("stomp");
//        if (!"ok".equals(req)) {
//            System.out.println("Authentication failed!");
//            session.close();
//        }
    }

    /**
     * 当有新的WebSocket连接完成时，对该方法进行回调
     *
     * @param session
     * @param headers
     * @param request
     * @param reqMap
     * @param arg
     * @param pathMap
     */
    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, @RequestParam String request, @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap) {
        log.info("success to new connection");
        System.out.println("new connection");
        System.out.println(request);
    }

    /**
     * 当有WebSocket连接关闭时，对该方法进行回调
     *
     * @param session
     * @throws IOException
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("one connection closed");
    }

    /**
     * 当有WebSocket抛出异常时，对该方法进行回调
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * 当接收到字符串消息时，对该方法进行回调
     *
     * @param session
     * @param message
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        log.info("websocket onmessage. {}.", message);
        System.out.println("接受消息"+message);
        ChatContentInfo chatContentInfo = chatContentInfoService.insertOne(message);
        if (Objects.nonNull(chatContentInfo)) {
            session.sendText(JSON.toJSONString(chatContentInfo));
            log.info("websocket onmessage.success to send {}.", chatContentInfo);
        }
    }

    /**
     * 当接收到二进制消息时，对该方法进行回调
     *
     * @param session
     * @param bytes
     */
    @OnBinary
    public void onBinary(Session session, byte[] bytes) {
        for (byte b : bytes) {
            System.out.println(b);
        }
        session.sendBinary(bytes);
    }

    /**
     * 当接收到Netty的事件时，对该方法进行回调
     *
     * @param session
     * @param evt
     */
    @OnEvent
    public void onEvent(Session session, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    System.out.println("read idle");
                    break;
                case WRITER_IDLE:
                    System.out.println("write idle");
                    break;
                case ALL_IDLE:
                    System.out.println("all idle");
                    break;
                default:
                    break;
            }
        }
    }

}