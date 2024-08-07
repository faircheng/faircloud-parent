package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 根据用户名获取用户信息 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "根据用户名获取用户信息 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class LoadUserByUsernameRequest extends Query {

    @NotBlank
    @Schema(description = "用户名Desc", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userName;
}
