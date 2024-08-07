package com.faircloud.iam.settings.client.module;

import com.faircloud.platform.common.module.Command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 设置云账号别名 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "设置云账号别名 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SetAccountAliasRequest extends Command {

    @NotBlank
    @Size(min = 3, max = 32)
    @Schema(name = "云账号的别名,长度为 3~32 个字符，可以包含小写字母、数字和短划线（-）")
    private String accountAlias;
}
