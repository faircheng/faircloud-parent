package com.faircloud.iam.password.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.faircloud.platform.audit.entity.AbstractAuditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 设置IAM用户密码强度等策略信息
 *
 * @author Fair
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "iam_password_policy")
@EqualsAndHashCode(callSuper = true)
public class PasswordPolicy extends AbstractAuditable<Long> {

    /**
     * 最小密码长度。取值范围：8~32。默认值：8。
     */
    private Integer minimumPasswordLength;

    /**
     * 密码中是否必须包含小写字母
     */
    private Boolean requireLowercaseCharacters;

    /**
     * 密码中是否必须包含大写字母
     */
    private Boolean requireUppercaseCharacters;

    /**
     * 密码中是否必须包含数字
     */
    private Boolean requireNumbers;

    /**
     * 密码中是否必须包含符号
     */
    private Boolean requireSymbols;

    /**
     * 密码过期后是否限制登录
     */
    private Boolean hardExpire;

    /**
     * 密码重试次数约束。连续输入错误密码达到设定次数后，账号将被锁定一小时。取值范围：0~32。默认值：0，表示不启用密码重试约束。
     */
    private Integer maxLoginAttemps;

    /**
     * 历史密码检查策略。禁止使用前N次的历史密码，N的取值范围：0~24。默认值：0，表示不启用历史密码检查策略。
     */
    private Integer passwordReusePrevention;

    /**
     * 密码有效期。取值范围：0~1095。单位：天。默认值：0，表示永不过期。
     */
    private Integer maxPasswordAge;

    /**
     * 账号ID
     */
    private Long userId;
}
