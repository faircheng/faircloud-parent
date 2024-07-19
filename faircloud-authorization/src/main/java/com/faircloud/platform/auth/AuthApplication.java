package com.faircloud.platform.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 统一授权中心启动类
 * 
 * @author Fair Cheng
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.faircloud")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
