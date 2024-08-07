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
 * 为权限策略创建新的版本 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "为权限策略创建新的版本 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreatePolicyVersionRequest extends Command {

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

    @Schema(name = "是否设置为默认权限策略，默认值为false")
    private Boolean setAsDefault;

    @Schema(name = "权限策略版本自动化轮转机制，可以删除历史权限策略版本。" +
        "目前包含：" +
        "None：关闭轮转机制。" +
        "DeleteOldestNonDefaultVersionWhenLimitExceeded：当权限策略版本数量超限时，删除最早且非活跃的版本。" +
        "默认值：None")
    private String rotateStrategy;
}
