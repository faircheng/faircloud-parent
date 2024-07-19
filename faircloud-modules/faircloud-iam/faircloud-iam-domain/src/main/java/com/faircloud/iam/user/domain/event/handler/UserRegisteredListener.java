package com.faircloud.iam.user.domain.event.handler;

import com.faircloud.iam.user.domain.event.UserRegisteredEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRegisteredListener {

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        // TODO:发个短信通知

    }
}
