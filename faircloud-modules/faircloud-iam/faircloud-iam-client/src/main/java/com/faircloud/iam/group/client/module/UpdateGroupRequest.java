package com.faircloud.iam.group.client.module;

import com.faircloud.platform.common.module.Command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 修改用户组信息 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "修改用户组信息 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGroupRequest extends Command {

    @NotBlank
    @Size(min = 1, max = 64)
    @Schema(name = "用户组名称。长度为 1~64 个字符，可包含英文字母、数字、英文句点（.）、下划线（_）和短划线（-）")
    private String groupName;

    @Size(min = 1, max = 64)
    @Schema(name = "用户组名称。长度为 1~64 个字符，可包含英文字母、数字、英文句点（.）、下划线（_）和短划线（-）")
    private String newGroupName;

    @Size(max = 128)
    @Schema(name = "显示名称")
    private String newDisplayName;

    @Size(max = 128)
    @Schema(name = "备注信息。最大长度 128 个字符。")
    private String newComments;
}
