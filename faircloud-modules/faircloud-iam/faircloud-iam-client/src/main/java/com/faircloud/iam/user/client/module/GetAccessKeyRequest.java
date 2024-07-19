package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

/**
 * 列出访问密钥 参数
 *
 * @author Fair Cheng
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
