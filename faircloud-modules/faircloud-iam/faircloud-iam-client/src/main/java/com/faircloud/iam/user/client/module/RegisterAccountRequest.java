package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Command;
import com.faircloud.platform.common.validator.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

/**
 * 账号密码注册 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "账号密码注册 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAccountRequest extends Command {

    @NotBlank
    @Schema(description = "登录名")
    @Size(min = 1, max = 64)
    private String userName;

    @Schema(description = "密码")
    private String password;

    @Mobile
    @Schema(description = "手机号码")
    private String mobilePhone;

    @NotBlank
    @Size(min = 6, max = 6)
    @Schema(description = "校验码")
    private String validationCode;
}
