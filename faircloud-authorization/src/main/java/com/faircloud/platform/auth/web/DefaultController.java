package com.faircloud.platform.auth.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.faircloud.platform.common.module.Response;

/**
 * default index
 * 
 * @author Fair Cheng
 */
@RestController
public class DefaultController {

    @GetMapping("/favicon.ico")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnNoContent() {
    }

    @GetMapping("/")
    public Response index() {
        return Response.success(SecurityContextHolder.getContext().getAuthentication());
    }
}
