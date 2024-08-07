package com.faircloud.iam.authority.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 查询IAM用户的授权列表 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "查询IAM用户的授权列表 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListPoliciesForUserRequest extends Query {

    @Schema(name = "IAM 用户名")
    private String userName;
}
