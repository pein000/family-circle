package com.family.circle.api.common.util;


import com.family.circle.api.common.enumeration.ResponseCodeEnum;
import com.family.circle.api.common.vo.response.CommonResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author q
 */
public class ResponseHelper {

    private ResponseHelper() {

    }

    /**
     * 成功结果无参数
     * result为null
     *
     * @param
     * @return
     */
    public static CommonResponse success() {
        return ofSuccess(null, null);
    }

    /**
     * 成功结果
     *
     * @param result
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> ofSuccess(T result) {
        return ofSuccess(null, result);
    }


    /**
     * 成功结果
     *
     * @param message
     * @param result
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> ofSuccess(String message, T result) {
        return new CommonResponse<T>()
                .setCode(ResponseCodeEnum.SUCCESS.getCode())
                .setMsg(message == null ? ResponseCodeEnum.SUCCESS.getMsg() : message)
                .setRespTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .setResult(result);
    }


    /**
     * 构建失败结果
     * result默认为null
     *
     * @param responseCodeEnum
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> ofFail(ResponseCodeEnum responseCodeEnum) {
        return ofFail(responseCodeEnum.getCode(), responseCodeEnum.getMsg());
    }

    /**
     * 构建失败结果
     * result默认为null
     *
     * @param responseCodeEnum
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> ofFail(ResponseCodeEnum responseCodeEnum, String message) {
        return ofFail(responseCodeEnum.getCode(), message);
    }


    /**
     * 构建失败结果
     * result默认为null
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> ofFail(String code, String message) {
        return ofFail(code, message, null);
    }

    /**
     * 构建失败结果
     *
     * @param code    失败编码
     * @param message 失败信息
     * @param result  结果
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> ofFail(String code, String message, T result) {
        return new CommonResponse<T>()
                .setCode(code)
                .setMsg(message)
                .setResult(result)
                .setRespTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }

}
