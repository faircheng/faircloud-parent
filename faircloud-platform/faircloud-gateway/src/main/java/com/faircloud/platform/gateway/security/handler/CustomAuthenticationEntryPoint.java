package com.faircloud.platform.gateway.security.handler;

import java.nio.charset.StandardCharsets;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.faircloud.platform.common.enums.StatusCodeEnum;
import com.faircloud.platform.common.module.Response;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * 用来解决匿名用户访问无权限资源时的异常
 *
 * @author Fair Cheng
 */
@Slf4j
public class CustomAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {

    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException ex) {
        log.info("用户未登录:{}", ex.getMessage());
        return Mono.defer(() -> Mono.just(exchange.getResponse())).flatMap(response -> {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            String res = JSON.toJSONString(Response.fail(StatusCodeEnum.A0220), JSONWriter.Feature.WriteMapNullValue);
            DataBuffer buffer = response.bufferFactory().wrap(res.getBytes(StandardCharsets.UTF_8));
            return response.writeWith(Mono.just(buffer)).doOnError(error -> DataBufferUtils.release(buffer));
        });
    }
}
