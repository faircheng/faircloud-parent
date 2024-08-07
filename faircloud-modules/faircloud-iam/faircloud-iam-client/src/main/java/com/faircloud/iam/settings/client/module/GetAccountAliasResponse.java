package com.faircloud.iam.settings.client.module;

import com.faircloud.platform.common.module.Command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 查看云账号别名 响应参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "查看云账号别名 响应参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountAliasResponse extends Command {

    @Schema(name = "云账号的别名")
    private String accountAlias;
}
