package com.faircloud.iam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.faircloud.platform.auth.security.handler.CustomAccessDeniedHandler;
import com.faircloud.platform.auth.security.handler.CustomAuthenticationEntryPoint;

/**
 * @author Steve Riesenberg
 * @since 1.3
 */
@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 禁用csrf
            .csrf((csrf) -> csrf.disable())
            // 禁用cors
            .cors((cors) -> cors.disable())
            // 权限配置
            .authorizeHttpRequests(authorize -> authorize
                // 放行swagger静态资源
                .requestMatchers("/doc.html", "/webjars/**", "/v3/**", "/swagger-resources/**").permitAll()
                // 用于监控和管理运行中的应用程序
                .requestMatchers("/actuator/**").permitAll()
                // 用户登录放行
                .requestMatchers("/**").permitAll()
                // 其他的拦截
                .anyRequest().authenticated())
            // 资源服务器配置
            .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
                // 无权限访问当前资源
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                // 用户未登录
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                // 默认解析
                .jwt(Customizer.withDefaults()))
            .exceptionHandling((exceptions) -> exceptions
                // 无权限访问当前资源
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                // 用户未登录
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()))
            .oauth2Client(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
