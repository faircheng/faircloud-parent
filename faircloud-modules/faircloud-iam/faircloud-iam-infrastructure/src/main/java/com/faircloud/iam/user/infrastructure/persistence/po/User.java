package com.faircloud.iam.user.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.faircloud.platform.audit.entity.AbstractAuditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 用户表
 * @author Fair
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "iam_user")
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractAuditable<Long> {

    /**
     * 主账号ID
     */
    private Long parentId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 手机号是否通过验证
     */
    private Boolean mobilePhoneIsVerify;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电子邮箱是否通过验证
     */
    private Boolean emailIsVerify;

    /**
     * 账户是否可用
     */
    private Boolean enabled;

    /**
     * description
     */
    private String description;

    /**
     * 是否删除
     */
    private Boolean deleted;
}
