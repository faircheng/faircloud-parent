package com.faircloud.iam.user.domain.model.entity;

import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.valueobject.Email;
import com.faircloud.iam.user.domain.model.valueobject.MobilePhone;
import com.faircloud.platform.common.model.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

/**
 * 用户信息
 *
 * @author Fair Cheng
 */
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoEntity implements Entity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 账号
     */
    private UserAggregate userId;

    /**
     * 显示名称
     */
    private String displayName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号码：仅作为备注信息，用户认证请绑定安全手机
     */
    private MobilePhone mobilePhone;

    /**
     * 电子邮箱：仅作为备注信息，用户认证请绑定安全邮箱
     */
    private Email email;

    /**
     * 备注
     */
    private String comments;
}
