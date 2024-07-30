/*
 * Copyright 2020-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.faircloud.platform.auth.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.faircloud.platform.web.security.handler.CustomAccessDeniedHandler;
import com.faircloud.platform.web.security.handler.CustomAuthenticationEntryPoint;
import com.faircloud.platform.web.security.handler.CustomLoginFailureHandler;
import com.faircloud.platform.web.security.handler.CustomLoginSuccessHandler;
import com.faircloud.platform.web.security.handler.CustomLogoutHandler;
import com.faircloud.platform.web.security.handler.CustomLogoutSuccessHandler;

/**
 * @author Joe Grandja
 * @author Steve Riesenberg
 * @since 1.1
 */
@Configuration
@EnableWebSecurity
public class DefaultSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            // 禁用csrf
            .csrf((csrf) -> csrf.disable())
            // 配置
            .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                // 放行swagger静态资源
                .requestMatchers("/doc.html", "/webjars/**", "/v3/**", "/swagger-resources/**").permitAll()
                // 用于监控和管理运行中的应用程序
                .requestMatchers("/actuator/**").permitAll()
                // 需要认证
                .anyRequest().authenticated())
            // 登出配置
            .logout((logout) -> logout
                // 自定义登出处理器
                .addLogoutHandler(new CustomLogoutHandler())
                // 自定义登出成功处理
                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                // 删除cookie
                .deleteCookies("AUTH_SERVER_SESSION_ID"))
            // 默认登录
            .formLogin((formLogin) -> formLogin
                // 登录失败
                .failureHandler(new CustomLoginFailureHandler())
                // 登录成功
                .successHandler(new CustomLoginSuccessHandler()))
            // 禁用basic认证
            .httpBasic((httpBasic) -> httpBasic.disable())
            // 禁用session
            // .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // 自定义异常处理
            .exceptionHandling((exceptionHandling) -> exceptionHandling
                // 无权限访问当前资源
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                // 用户未登录
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()));
        return http.build();
    }

    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user =
            User.builder().username("user1").password(passwordEncoder().encode("password")).roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    @ConditionalOnMissingBean(AuthenticationEventPublisher.class)
    DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher(ApplicationEventPublisher delegate) {
        return new DefaultAuthenticationEventPublisher(delegate);
    }
}
