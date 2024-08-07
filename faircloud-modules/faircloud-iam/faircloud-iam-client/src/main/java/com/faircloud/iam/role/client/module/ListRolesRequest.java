package com.faircloud.iam.role.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 获取角色列表 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "获取角色列表 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListRolesRequest extends Query {

    @Schema(name = "角色名称")
    private String roleName;
}
