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
 * 列出权限策略版本 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(title = "列出权限策略版本 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListPolicyVersionsRequest extends Query {

    @NotBlank
    @Schema(title = "指定Policy的类型", description = "取值为System或Custom，如果没有指定则列出所有权限策略。")
    private String policyType;

    @NotBlank
    @Schema(title = "指定权限策略名称")
    private String policyName;
}
