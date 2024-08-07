package com.faircloud.iam.role.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 获取角色信息 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "获取角色信息 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetRoleRequest extends Query {

    @NotBlank
    @Schema(description = "指定角色名")
    private String roleName;
}
