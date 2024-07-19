package com.faircloud.platform.web.security.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 * 自定义登出业务
 *
 * @author Fair Cheng
 */
public class CustomLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 我们实现的 LogoutHandler 。 我们可以从 logout 方法的 authentication 变量中 获取当前用户信息。你可以通过这个来实现你具体想要的业务。比如记录用户下线退出时间、IP 等等

    }
}
