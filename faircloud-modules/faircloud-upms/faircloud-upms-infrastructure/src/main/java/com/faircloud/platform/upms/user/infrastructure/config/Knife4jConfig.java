package com.faircloud.platform.upms.user.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * knife4j 配置
 * @author Fair Cheng
 */
@EnableSwagger2
@Configuration
public class Knife4jConfig {

    @Bean
    public Docket serviceApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.faircloud.platform.upms"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("用户服务")
                .description("用户服务接口文档")
                .termsOfServiceUrl("http://www.baidu.com/")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
