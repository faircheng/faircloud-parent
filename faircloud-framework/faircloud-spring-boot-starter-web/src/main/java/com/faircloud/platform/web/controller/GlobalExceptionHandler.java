package com.faircloud.platform.web.controller;

import com.alibaba.fastjson2.JSON;
import com.faircloud.platform.common.enums.StatusCodeEnum;
import com.faircloud.platform.common.exception.BusinessException;
import com.faircloud.platform.common.module.Response;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 自定义异常处理
 *
 * @author fair cheng
 * @date 2019-1-11
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 用于@Valid参数效验错误信息捕获
     *
     * @param e 异常信息
     * @return ResponseDTO
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleException(Exception e) {
        log.info("参数效验错误信息捕获:{}", e.getMessage(), e);
        BindingResult result;
        if (e instanceof MethodArgumentNotValidException) {
            result = ((MethodArgumentNotValidException) e).getBindingResult();
        } else {
            result = ((BindException) e).getBindingResult();
        }
        List<String> errors = Lists.newArrayList();
        for (FieldError error : result.getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : result.getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        return new Response(StatusCodeEnum.A0402.getCode(), JSON.toJSONString(errors), null);
    }

    /**
     * 用户没有登录
     *
     * @param e 异常
     * @return ResponseDTO
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Response authenticationException(AuthenticationException e) {
        log.info("用户没有登录:{}", e.getMessage(), e);
        return new Response<>(StatusCodeEnum.A0220);
    }

    /**
     * 无权限访问当前资源
     *
     * @param e 异常
     * @return ResponseDTO
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Response accessDeniedException(AccessDeniedException e) {
        log.info("无权限访问当前资源:{}", e.getMessage(), e);
        return new Response<>(StatusCodeEnum.A0301);
    }

    /**
     * 业务异常信息
     *
     * @param e 异常
     * @return ResponseDTO
     */
    @ExceptionHandler(BusinessException.class)
    public Response businessException(BusinessException e) {
        log.info("业务处理异常:{}", e.getMessage(), e);
        return new Response<>(e.getCode());
    }

    /**
     * 捕捉其他所有异常
     *
     * @param e 异常
     * @return dto
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response globalException(Exception e) {
        log.error("服务器异常:{}", e.getMessage(), e);
        return new Response(StatusCodeEnum.B0001);
    }
}
