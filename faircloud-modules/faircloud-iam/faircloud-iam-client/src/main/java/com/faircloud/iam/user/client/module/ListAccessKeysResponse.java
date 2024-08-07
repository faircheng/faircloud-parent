package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 列出指定用户的访问密钥 返回参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "列出指定用户的访问密钥 返回参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListAccessKeysResponse extends DTO {

    @Schema(description = "用户名")
    private String userName;
}
