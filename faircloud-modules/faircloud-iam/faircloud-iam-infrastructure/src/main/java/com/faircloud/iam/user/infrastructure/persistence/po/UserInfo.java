package com.faircloud.iam.user.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.valueobject.Email;
import com.faircloud.iam.user.domain.model.valueobject.MobilePhone;
import com.faircloud.platform.audit.entity.AbstractAuditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 用户信息表
 * @author Fair
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "iam_user_info")
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends AbstractAuditable<Long> {

    /**
     * 账号
     */
    private Long userId;

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
    private String mobilePhone;

    /**
     * 电子邮箱：仅作为备注信息，用户认证请绑定安全邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String comments;
}
