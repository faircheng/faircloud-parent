package com.faircloud.iam.user.domain.model.valueobject;

import lombok.Builder;
import lombok.Value;

/**
 * 邮件
 *
 * @author Fair Cheng
 */
@Value
@Builder
public class Email {

    private String email;

    public Email(String email) {

        this.email = email;
    }
}
