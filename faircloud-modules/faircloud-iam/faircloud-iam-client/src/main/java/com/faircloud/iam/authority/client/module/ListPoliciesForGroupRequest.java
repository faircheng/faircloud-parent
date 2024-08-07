package com.faircloud.iam.authority.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 列出用户组的权限策略 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "列出用户组的权限策略 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListPoliciesForGroupRequest extends Query {

    @Schema(name = "用户组名称")
    private String groupName;
}
