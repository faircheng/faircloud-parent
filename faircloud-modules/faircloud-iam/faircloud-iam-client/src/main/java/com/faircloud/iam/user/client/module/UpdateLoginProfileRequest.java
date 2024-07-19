package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Command;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

/**
 * 修改IAM用户启用Web控制台登录 请求参数
 *
 * @author Fair Cheng
 */
@Data
@Builder
@Schema(description = "修改IAM用户启用Web控制台登录 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLoginProfileRequest extends Command {

    @NotBlank
    @Schema(description = "用户名")
    @Size(min = 1, max = 64)
    private String userName;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "指定用户在登录时是否需要修改密码。默认为false")
    private Boolean passwordResetRequired;

    @Schema(description = "指定用户在下次登录时是否必须绑定多因素认证器。默认为false")
    private Boolean MFABindRequired;
}
