package com.faircloud.iam.role.client.module;

import com.faircloud.platform.common.module.Command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 更新角色信息 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "更新角色信息 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleRequest extends Command {

    @NotBlank
    @Size(min = 1, max = 64)
    @Schema(name = "用户组名称。长度为 1~64 个字符，可包含英文字母、数字、英文句点（.）、下划线（_）和短划线（-）")
    private String roleName;

    @Size(max = 128)
    @Schema(name = "显示名称")
    private String newDisplayName;

    @Size(min = 1, max = 1024)
    @Schema(name = "角色描述。长度为 1~1024 个字符。")
    private String newDescription;

    @NotBlank
    @Schema(name = "信任策略。指定允许扮演该 IAM 角色的一个或多个主体，这个主体可以是账号、服务或身份提供商。")
    private String newAssumeRolePolicyDocument;

    @Min(value = 3600)
    @Max(value = 43200)
    @Schema(name = "IAM 角色最大会话时间。取值范围：3600 秒~43200 秒。默认值：3600 秒。取值为空时将采用默认值。")
    private Long newMaxSessionDuration;
}
