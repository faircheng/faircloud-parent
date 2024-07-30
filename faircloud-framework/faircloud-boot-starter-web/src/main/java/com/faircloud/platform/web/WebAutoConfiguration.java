package com.faircloud.platform.web;

import com.faircloud.platform.web.config.WebMvcConfig;
import com.faircloud.platform.web.controller.GlobalExceptionController;
import com.faircloud.platform.web.controller.GlobalExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web starter
 *
 * @author Fair Cheng
 */
@Configuration
@RequiredArgsConstructor
@AutoConfigureBefore(ErrorMvcAutoConfiguration.class)
public class WebAutoConfiguration {

    private final ErrorAttributes errorAttributes;

    @Bean
    @ConditionalOnMissingBean(WebMvcConfig.class)
    public WebMvcConfig webMvcConfig() {
        return new WebMvcConfig();
    }

    @Bean
    @ConditionalOnMissingBean(GlobalExceptionController.class)
    public GlobalExceptionController globalExceptionController() {
        return new GlobalExceptionController(errorAttributes);
    }

    @Bean
    @ConditionalOnMissingBean(GlobalExceptionHandler.class)
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
