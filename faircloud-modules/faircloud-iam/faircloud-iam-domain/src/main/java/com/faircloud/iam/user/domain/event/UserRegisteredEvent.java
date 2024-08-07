package com.faircloud.iam.user.domain.event;

import org.springframework.context.ApplicationEvent;

import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;

import lombok.Getter;

/**
 * 用户注册事件
 *
 * @author Felix Cheng
 */
public class UserRegisteredEvent extends ApplicationEvent {

    @Getter
    private final UserAggregate aggregate;

    public UserRegisteredEvent(Object source, UserAggregate aggregate) {
        super(source);
        this.aggregate = aggregate;
    }
}
