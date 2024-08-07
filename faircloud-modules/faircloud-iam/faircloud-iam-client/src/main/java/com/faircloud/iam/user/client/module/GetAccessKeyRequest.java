package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 列出访问密钥 参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "列出访问密钥 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetAccessKeyRequest extends Query {

    @Schema(description = "指定用户名")
    private String userName;
}
