package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 删除一个IAM用户 参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "删除一个IAM用户 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserRequest extends Command {

    @NotBlank
    @Schema(description = "IAM 用户名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userName;
}
