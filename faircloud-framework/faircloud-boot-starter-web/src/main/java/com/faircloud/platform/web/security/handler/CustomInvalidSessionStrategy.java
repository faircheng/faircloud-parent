package com.faircloud.platform.web.security.handler;

import com.faircloud.platform.common.enums.StatusCodeEnum;
import com.faircloud.platform.common.module.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.web.session.InvalidSessionStrategy;

import java.io.IOException;

/**
 * 自定义配置无效session策略
 *
 * @author Fair Cheng
 */
@Slf4j
public class CustomInvalidSessionStrategy implements InvalidSessionStrategy {

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.info("当前登录已失效！请重新登录");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), Response.fail(StatusCodeEnum.A0220));
    }
}
