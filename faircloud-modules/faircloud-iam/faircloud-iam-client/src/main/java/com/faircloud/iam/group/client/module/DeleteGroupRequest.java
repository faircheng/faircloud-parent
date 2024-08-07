package com.faircloud.iam.group.client.module;

import com.faircloud.platform.common.module.Command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 删除指定的用户组 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "删除指定的用户组 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class DeleteGroupRequest extends Command {

    @NotBlank
    @Schema(name = "用户组名称")
    private String groupName;
}
