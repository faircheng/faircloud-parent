package com.faircloud.iam.authority.client.module;

import com.faircloud.platform.common.module.Command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 设置权限策略默认版本 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "设置权限策略默认版本 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SetDefaultPolicyVersionRequest extends Command {

    @NotBlank
    @Schema(name = "权限策略名称")
    private String policyName;

    @NotBlank
    @Schema(name = "新默认版本的 ID")
    private String versionId;
}
