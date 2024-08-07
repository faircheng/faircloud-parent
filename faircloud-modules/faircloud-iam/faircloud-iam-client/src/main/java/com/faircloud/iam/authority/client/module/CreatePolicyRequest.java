package com.faircloud.iam.authority.client.module;

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
 * 创建一个权限策略 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "创建一个权限策略 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreatePolicyRequest extends Command {

    @NotBlank
    @Size(min = 1, max = 128)
    @Schema(name = "权限策略名称。长度为 1~128 个字符，可包含英文字母、数字和短划线（-）")
    private String policyName;

    @Size(min = 1, max = 1024)
    @Schema(name = "权限策略描述。长度为 1~1024 个字符。")
    private String description;

    @NotBlank
    @Size(min = 1, max = 6144)
    @Schema(name = "权限策略内容。长度为 1~6144 个字符。")
    private String policyDocument;
}
