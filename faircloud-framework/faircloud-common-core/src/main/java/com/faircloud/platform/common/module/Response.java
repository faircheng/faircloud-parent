package com.faircloud.platform.common.module;

import java.io.Serializable;

import com.faircloud.platform.common.enums.StatusCode;
import com.faircloud.platform.common.enums.StatusCodeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公用返回类
 *
 * @author Felix Cheng
 */
@Data
@NoArgsConstructor
@Tag(name = "统一返回结果处理")
public class Response<T> implements Serializable {

    /**
     * http 状态码
     */
    @Schema(title = "状态码", description = "200")
    private String code;

    /**
     * 返回信息
     */
    @Schema(title = "返回信息")
    private String msg;

    /**
     * 返回的数据
     */
    @Schema(title = "返回的数据")
    private T data;

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public Response(StatusCode statusCode, T data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    public static Response success() {
        return new Response(StatusCodeEnum.OK);
    }

    public static Response success(Object data) {
        return new Response(StatusCodeEnum.OK, data);
    }

    public static Response fail() {
        return new Response(StatusCodeEnum.B0001);
    }

    public static Response fail(StatusCode code) {
        return new Response(code);
    }

    public static <T> Response<T> fail(StatusCode code, T data) {
        return new Response(code, data);
    }
}
