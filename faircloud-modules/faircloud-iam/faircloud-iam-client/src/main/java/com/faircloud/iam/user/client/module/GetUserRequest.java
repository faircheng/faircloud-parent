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
 * 查询IAM用户的详细信息 参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "查询IAM用户的详细信息 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetUserRequest extends Query {

    @NotBlank
    @Schema(description = "IAM 用户的名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userName;
}
