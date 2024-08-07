package com.faircloud.platform.auth.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.faircloud.platform.common.module.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * default index
 *
 * @author Felix Cheng
 */
@Tag(name = "默认前端处理器")
@RestController
public class DefaultController {

    @Operation(summary = "favicon")
    @GetMapping("/favicon.ico")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnNoContent() {
    }

    @Operation(summary = "首页")
    @GetMapping("/index")
    public Response index() {
        return Response.success(SecurityContextHolder.getContext().getAuthentication());
    }
}
