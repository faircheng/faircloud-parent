package com.faircloud.platform.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.faircloud.platform.auth.interceptor.AuthInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * 静态文件部署
 *
 * @author Felix Cheng
 */
@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("starter auth");
        registry.addInterceptor(new AuthInterceptor());
    }

    /**
     * 访问外部文件配置，访问D盘下文件
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
