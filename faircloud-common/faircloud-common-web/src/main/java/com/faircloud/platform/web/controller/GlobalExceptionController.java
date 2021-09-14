package com.faircloud.platform.web.controller;

import com.faircloud.platform.common.dto.ResponseDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 全局异常处理
 * @author Fair Cheng
 * @date 2020-3-1 20:16:42
 */
@Slf4j
@RestController
@Api(value = "全局异常处理")
public class GlobalExceptionController extends BasicErrorController {

    public GlobalExceptionController(ErrorAttributes errorAttributes) {
        super(errorAttributes, new ErrorProperties());
    }

    /**
     * 重写 error 方法
     * @param request 请求
     * @return ResponseDTO
     */
    @Override
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity<>(status);
        }
        Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL));
        // 拿到 body 中的异常 message
        String message = body.get("message").toString();
        return new ResponseEntity(ResponseDTO.fail(status.value(),message), status);
    }
}
