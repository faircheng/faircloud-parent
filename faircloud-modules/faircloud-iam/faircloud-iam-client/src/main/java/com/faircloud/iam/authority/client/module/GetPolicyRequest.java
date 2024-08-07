package com.faircloud.iam.authority.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 获取指定的权限策略信息 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "获取指定的权限策略信息 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetPolicyRequest extends Query {

    @NotBlank
    @Schema(description = "指定权限策略的类型，取值为System或Custom")
    private String policyType;

    @NotBlank
    @Schema(description = "指定权限策略名称")
    private String policyName;
}
