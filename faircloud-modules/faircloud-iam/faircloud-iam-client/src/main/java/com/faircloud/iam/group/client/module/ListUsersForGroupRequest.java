package com.faircloud.iam.group.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 列出指定用户组所包含的IAM用户 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "列出指定用户组所包含的IAM用户 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListUsersForGroupRequest extends Query {

    @NotBlank
    @Schema(description = "用户组名称")
    private String groupName;
}
