package com.faircloud.iam.user.domain.event;

import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 用户注册事件
 *
 * @author Fair Cheng
 */
public class UserRegisteredEvent extends ApplicationEvent {

    @Getter
    private final UserAggregate aggregate;

    public UserRegisteredEvent(Object source, UserAggregate aggregate) {
        super(source);
        this.aggregate = aggregate;
    }
}
