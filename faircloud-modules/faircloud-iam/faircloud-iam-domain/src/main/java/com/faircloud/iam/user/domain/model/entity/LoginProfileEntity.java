package com.faircloud.iam.user.domain.model.entity;

import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.platform.common.model.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * 用户登录信息
 *
 * @author Fair Cheng
 */
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LoginProfileEntity implements Entity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 账号
     */
    private UserAggregate userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 下次登录时是否必须重置密码
     */
    private Boolean passwordResetRequired;

    /**
     * 上次登录时间
     */
    private Date lastLoginDate;

    /**
     * 上次登录Ip
     */
    private String lastLoginIp;

    /**
     * 控制台访问：开启或禁用
     */
    private Boolean enabled;

    /**
     * 用户过期
     */
    private Boolean accountNonExpired;

    /**
     * 用户锁定
     */
    private Boolean accountNonLocked;

    /**
     * 密码过期
     */
    private Boolean credentialsNonExpired;
}
