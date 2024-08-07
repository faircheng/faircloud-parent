package com.faircloud.platform.gateway.security.handler;

import java.nio.charset.StandardCharsets;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.faircloud.platform.common.enums.StatusCodeEnum;
import com.faircloud.platform.common.module.Response;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * 用来解决认证过的用户访问无权限资源时的异常
 *
 * @author Felix Cheng
 */
@Slf4j
public class CustomAccessDeniedHandler implements ServerAccessDeniedHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, AccessDeniedException denied) {
        log.info("无权限访问:{}", denied.getMessage());
        return Mono.defer(() -> Mono.just(exchange.getResponse())).flatMap(response -> {
            response.setStatusCode(HttpStatus.FORBIDDEN);
            String res = JSON.toJSONString(Response.fail(StatusCodeEnum.A0301), JSONWriter.Feature.WriteMapNullValue);
            DataBuffer buffer = response.bufferFactory().wrap(res.getBytes(StandardCharsets.UTF_8));
            return response.writeWith(Mono.just(buffer)).doOnError(error -> DataBufferUtils.release(buffer));
        });
    }
}
