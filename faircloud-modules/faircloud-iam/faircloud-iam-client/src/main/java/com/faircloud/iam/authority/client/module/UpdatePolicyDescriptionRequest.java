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
 * 更新自定义策略的描述信息 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "更新自定义策略的描述信息 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePolicyDescriptionRequest extends Command {

    @NotBlank
    @Schema(name = "权限策略名称")
    private String policyName;

    @Size(min = 1, max = 1024)
    @Schema(name = "权限策略描述。长度为 1~1024 个字符")
    private String newDescription;
}
