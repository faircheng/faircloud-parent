package com.faircloud.iam.user.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.faircloud.platform.audit.entity.AbstractAuditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * 登录信息
 * @author Felix Cheng
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "iam_login_profile")
@EqualsAndHashCode(callSuper = true)
public class LoginProfile extends AbstractAuditable<Long> {

    /**
     * 账户ID
     */
    private Long userId;

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
     * 用户过期
     */
    @TableField(value = "is_account_non_expired")
    private Boolean accountNonExpired;

    /**
     * 用户锁定
     */
    @TableField(value = "is_account_non_locked")
    private Boolean accountNonLocked;

    /**
     * 密码过期
     */
    @TableField(value = "is_credentials_non_expired")
    private Boolean credentialsNonExpired;

    /**
     * 控制台访问：开启或禁用
     */
    @TableField(value = "is_enabled")
    private Boolean enabled;
}
