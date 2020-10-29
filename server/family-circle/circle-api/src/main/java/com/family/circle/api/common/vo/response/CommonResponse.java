package com.family.circle.api.common.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author q
 */
@ApiModel(description = "响应参数")
public class CommonResponse<T> implements Serializable {

    /**
     * 响应时间 格式化字符串
     */
    @ApiModelProperty(value = "响应时间，格式yyyy-MM-dd HH:mm:ss.SSS")
    private String respTime;

    /**
     * 返回值
     */
    @ApiModelProperty(value = "响应码，0-成功")
    private String code;

    /**
     * 返回消息
     */
    @ApiModelProperty(value = "响应消息，错误信息")
    private String msg;

    /**
     * 响应数据
     */
    @ApiModelProperty(value = "响应数据")
    private T result;

    public String getRespTime() {
        return respTime;
    }

    public CommonResponse<T> setRespTime(String respTime) {
        this.respTime = respTime;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CommonResponse<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public CommonResponse<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getResult() {
        return result;
    }

    public CommonResponse<T> setResult(T result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"respTime\":\"")
                .append(respTime).append('\"');
        sb.append(",\"code\":\"")
                .append(code).append('\"');
        sb.append(",\"msg\":\"")
                .append(msg).append('\"');
        sb.append(",\"result\":")
                .append(result);
        sb.append('}');
        return sb.toString();
    }
}