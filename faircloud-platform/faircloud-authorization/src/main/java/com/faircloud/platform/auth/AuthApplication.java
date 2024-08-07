package com.faircloud.platform.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.faircloud.iam.user.client.api.UserClient;

/**
 * 统一授权中心启动类
 *
 * @author Felix Cheng
 */
@EnableFeignClients(clients = UserClient.class)
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.faircloud")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
