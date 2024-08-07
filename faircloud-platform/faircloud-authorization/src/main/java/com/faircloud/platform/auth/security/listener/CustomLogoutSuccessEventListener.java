package com.faircloud.platform.auth.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.LogoutSuccessEvent;

/**
 * 退出成功
 *
 * @author Felix Cheng
 */
public class CustomLogoutSuccessEventListener implements ApplicationListener<LogoutSuccessEvent> {

    @Override
    public void onApplicationEvent(LogoutSuccessEvent event) {

    }
}
