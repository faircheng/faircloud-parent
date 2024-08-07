package com.faircloud.iam.authority.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 列出权限策略 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "列出权限策略 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListPoliciesRequest extends Query {

    @Schema(title ="指定Policy的类型", description = "取值为System或Custom，如果没有指定则列出所有权限策略。")
    private String policyType;
}
