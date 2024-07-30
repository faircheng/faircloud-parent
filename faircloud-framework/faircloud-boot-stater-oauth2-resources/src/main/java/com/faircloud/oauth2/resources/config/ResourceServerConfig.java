package com.faircloud.oauth2.resources.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.faircloud.oauth2.resources.properties.Oauth2ResourcesProperties;

/**
 * 默认资源服务配置
 *
 * @author Fair Cheng
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(Oauth2ResourcesProperties.class)
public class ResourceServerConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, Oauth2ResourcesProperties properties) throws Exception {
        http
            // 禁用csrf
            .csrf((csrf) -> csrf.disable())
            // 禁用cors
            .cors((cors) -> cors.disable())
            // 权限配置
            .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
            // 资源服务器配置
            .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()));

        return http.build();
    }
}
