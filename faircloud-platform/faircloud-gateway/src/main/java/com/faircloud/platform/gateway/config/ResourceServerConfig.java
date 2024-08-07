package com.faircloud.platform.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.faircloud.platform.gateway.security.handler.CustomAccessDeniedHandler;
import com.faircloud.platform.gateway.security.handler.CustomAuthenticationEntryPoint;

/**
 * 资源服务器配置
 *
 * @author Felix Cheng
 * @since 1.3
 */
@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityWebFilterChain defaultSecurityFilterChain(ServerHttpSecurity http) {
        http
            // 禁用csrf
            .csrf((csrf) -> csrf.disable())
            // 禁用cors
            .cors((cors) -> cors.disable())
            // 拦截配置
            .authorizeExchange((exchanges) -> exchanges
                // 获取code编码
                .pathMatchers("/authorized").permitAll()
                // 需要授权认证
                .anyExchange().authenticated())
            // 设置当前服务为资源服务，解析请求头中的token
            .oauth2ResourceServer((oauth2ResourceServer) -> oauth2ResourceServer
                // 无权限访问当前资源
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                // 用户未登录
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                // 默认解析
                .jwt(Customizer.withDefaults()))
            // 自定义异常处理
            .exceptionHandling((exceptionHandling) -> exceptionHandling
                // 无权限访问当前资源
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                // 用户未登录
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()))
            .oauth2Client(Customizer.withDefaults());

        return http.build();
    }
}
