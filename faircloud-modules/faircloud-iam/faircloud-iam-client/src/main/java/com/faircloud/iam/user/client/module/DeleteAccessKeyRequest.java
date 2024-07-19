package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Command;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

/**
 * 删除访问密钥 参数
 *
 * @author Fair Cheng
 */
@Data
@Builder
@Schema(description = "删除访问密钥 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class DeleteAccessKeyRequest extends Command {

    @Schema(description = "指定用户名")
    private String userName;

    @Schema(description = "指定要删除的AccessKeyId")
    private String userAccessKeyId;
}
