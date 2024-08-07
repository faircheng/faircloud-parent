package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Command;
import com.faircloud.platform.common.validator.Mobile;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 创建用户
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(title = "创建用户 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest extends Command {

    @NotBlank
    @Schema(description = "用户名。长度为 1~64 个字符，可包含英文字母、数字、半角句号（.）、短划线（-）和下划线（_）", requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 1, max = 64)
    private String userName;

    @Size(min = 1, max = 128)
    @Schema(description = "用户的显示名称。长度为 1~128 个字符")
    private String displayName;

    @Mobile(required = false)
    @Schema(description = "手机号码")
    private String mobilePhone;

    @Email
    @Schema(description = "电子邮箱")
    private String email;

    @Schema(description = "备注。长度为 1~128 个字符")
    @Size(min = 1, max = 128)
    private String comments;
}
