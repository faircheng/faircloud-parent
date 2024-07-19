package com.faircloud.iam.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * knife4j 配置
 * @author Fair Cheng
 */
@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI serviceApis() {
        return new OpenAPI().info(new Info().title("用户服务").version("1.0").description("用户服务接口文档").termsOfService("http://doc.faircloud.com"));
    }
}
