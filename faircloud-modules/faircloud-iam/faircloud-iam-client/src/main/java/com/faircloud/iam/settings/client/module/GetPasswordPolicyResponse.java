package com.faircloud.iam.settings.client.module;

import com.faircloud.platform.common.module.Command;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 获取IAM用户密码强度等策略信息 响应参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "获取IAM用户密码强度等策略信息 响应参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetPasswordPolicyResponse extends Command {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "最小密码长度。取值范围：8~32。默认值：8。")
    private Integer minimumPasswordLength;

    @Schema(description = "密码中是否必须包含小写字母")
    private Boolean requireLowercaseCharacters;

    @Schema(description = "密码中是否必须包含大写字母")
    private Boolean requireUppercaseCharacters;

    @Schema(description = "密码中是否必须包含数字")
    private Boolean requireNumbers;

    @Schema(description = "密码中是否必须包含符号")
    private Boolean requireSymbols;

    @Schema(description = "密码过期后是否限制登录")
    private Boolean hardExpire;

    @Schema(description = "密码重试次数约束。连续输入错误密码达到设定次数后，账号将被锁定一小时。取值范围：0~32。默认值：0，表示不启用密码重试约束。")
    private Integer maxLoginAttemps;

    @Schema(description = "历史密码检查策略。禁止使用前N次的历史密码，N的取值范围：0~24。默认值：0，表示不启用历史密码检查策略。")
    private Integer passwordReusePrevention;

    @Schema(description = "密码有效期。取值范围：0~1095。单位：天。默认值：0，表示永不过期。")
    private Integer maxPasswordAge;
}
