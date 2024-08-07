package com.faircloud.platform.auth.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;

/**
 * 认证失败
 *
 * @author xianghui cheng
 */
public class CustomAuthenticationFailureEventListener implements ApplicationListener<AbstractAuthenticationFailureEvent> {

    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {

    }
}
