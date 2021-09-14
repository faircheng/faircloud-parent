package com.faircloud.platform.web.exception;

import com.faircloud.platform.common.dto.ResponseDTO;
import com.faircloud.platform.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 自定义异常处理
 * @author fair cheng
 * @date 2019-1-11
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 用于@Valid参数效验错误信息捕获
     * @param exception 异常信息
     * @return ResponseDTO
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseDTO handleException(Exception exception) {
        BindingResult result;
        if (exception instanceof MethodArgumentNotValidException) {
            result = ((MethodArgumentNotValidException) exception).getBindingResult();
        } else {
            result = ((BindException) exception).getBindingResult();
        }
        FieldError fieldError = result.getFieldError();
        String message = "非法参数";
        if (fieldError == null) {
            List<ObjectError> errorList = result.getAllErrors();
            if (!errorList.isEmpty()) {
                message = errorList.get(0).getDefaultMessage();
            }
        } else {
            message = fieldError.getDefaultMessage();
        }
        log.error(message, exception);
        return ResponseDTO.fail(HttpStatus.BAD_REQUEST.value(), message);
    }

    /**
     * 用户没有登录
     * @param e 异常
     * @return ResponseDTO
     */
    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseDTO accessDeniedException(InsufficientAuthenticationException e) {
        log.info("用户没有登录:{}", e.getMessage(), e);
        return ResponseDTO.fail(HttpStatus.UNAUTHORIZED.value(), "用户没有登录");
    }

    /**
     * 无权限访问当前资源
     * @param e 异常
     * @return ResponseDTO
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseDTO accessDeniedException(AccessDeniedException e) {
        log.info("无权限访问当前资源:{}", e.getMessage(), e);
        return ResponseDTO.fail(HttpStatus.FORBIDDEN.value(), "无权限访问当前资源");
    }

    /**
     * 捕捉其他所有异常
     * @param e 异常
     * @return dto
     */
    @ExceptionHandler(Exception.class)
    public ResponseDTO globalException(Exception e) {
        log.error("服务器异常:{}", e.getMessage(), e);
        return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    /**
     * 业务异常信息
     * @param e 异常
     * @return ResponseDTO
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseDTO businessException(BusinessException e) {
        log.info("业务处理异常:{}", e.getMessage(), e);
        return ResponseDTO.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
