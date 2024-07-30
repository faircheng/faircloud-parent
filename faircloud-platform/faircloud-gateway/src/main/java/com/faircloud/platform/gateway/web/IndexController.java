package com.faircloud.platform.gateway.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faircloud.platform.common.module.Response;

import lombok.extern.slf4j.Slf4j;

/**
 * 默认首页显示
 *
 * @author Fair Cheng
 */
@Slf4j
@RestController
public class IndexController {

    @GetMapping("/")
    public Response index() {
        return Response.success();
    }

    @GetMapping("/authorized")
    public Response authorized(@RequestParam String code) {

        return Response.success(code);
    }
}
