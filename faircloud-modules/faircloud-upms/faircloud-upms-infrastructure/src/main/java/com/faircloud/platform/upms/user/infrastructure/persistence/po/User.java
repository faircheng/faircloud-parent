package com.faircloud.platform.upms.user.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户表
 * @author Fair
 */
@Data
@TableName(value = "SYS_USER")
public class User {

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 照片
     */
    private String photo;

    /**
     * 账户是否可用
     */
    private Boolean enabled = Boolean.TRUE;

    /**
     * 账户是否过期
     */
    private Boolean accountNonExpired = Boolean.TRUE;

    /**
     * 密码是否过期
     */
    private Boolean credentialsNonExpired = Boolean.TRUE;

    /**
     * 账户是否锁定
     */
    private Boolean accountNonLocked = Boolean.TRUE;
}
