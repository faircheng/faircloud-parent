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
 * 为指定角色添加权限 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "为指定角色添加权限 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AttachPolicyToRoleRequest extends Command {

    @NotBlank
    @Schema(name = "指定权限策略的类型，取值为System或Custom")
    public String policyType;

    @NotBlank
    @Schema(name = "权限策略名称")
    public String policyName;

    @NotBlank
    @Schema(name = "角色名")
    public String roleName;
}
