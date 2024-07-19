package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Command;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

/**
 * 创建访问密钥 参数
 *
 * @author Fair Cheng
 */
@Data
@Builder
@Schema(description = "创建访问密钥 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccessKeyRequest extends Command {

    @Schema(description = "指定用户名，IAM 用户调用此接口时，默认为自己创建访问密钥。")
    private String userName;
}
