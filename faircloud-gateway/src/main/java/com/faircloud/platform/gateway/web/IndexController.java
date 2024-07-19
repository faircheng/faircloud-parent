package com.faircloud.platform.gateway.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faircloud.platform.common.module.Response;

/**
 * 默认首页显示
 *
 * @author Fair Cheng
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public Response index() {

        return Response.success();
    }
}
