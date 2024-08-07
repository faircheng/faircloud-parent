package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 查询指定访问密钥的最后使用时间 参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "查询指定访问密钥的最后使用时间 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetAccessKeyLastUsedRequest extends Query {

    @Schema(name = "IAM 用户名称")
    private String userName;

    @Schema(name = "需要查询的访问密钥 ID")
    private String userAccessKeyId;
}
