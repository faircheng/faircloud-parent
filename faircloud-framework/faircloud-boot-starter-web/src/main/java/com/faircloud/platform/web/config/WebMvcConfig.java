package com.faircloud.platform.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
        log.info("starter web");
    }

    /**
     * 访问外部文件配置，访问D盘下文件
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
