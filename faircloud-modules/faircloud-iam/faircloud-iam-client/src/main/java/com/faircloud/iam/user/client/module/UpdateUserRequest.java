package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Command;
import com.faircloud.platform.common.validator.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

/**
 * 更新用户的基本信息 请求参数
 *
 * @author Fair Cheng
 */
@Data
@Builder
@Schema(description = "更新用户的基本信息 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest extends Command {

    @NotBlank
    @Schema(description = "用户名")
    @Size(min = 1, max = 64)
    private String UserName;

    @NotBlank
    @Schema(description = "用户的新名称")
    @Size(min = 1, max = 64)
    private String newUserName;

    @Size(min = 1, max = 128)
    @Schema(description = "用户的新显示名称")
    private String newDisplayName;

    @Mobile(required = false)
    @Schema(description = "手机号码")
    private String newMobilePhone;

    @Email
    @Schema(description = "电子邮箱")
    private String newEmail;

    @Schema(description = "备注")
    @Size(min = 1, max = 128)
    private String newComments;
}
