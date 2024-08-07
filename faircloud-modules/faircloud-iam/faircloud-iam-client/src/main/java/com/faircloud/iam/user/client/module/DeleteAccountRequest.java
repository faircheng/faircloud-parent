package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.Command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 删除一个IAM账号 参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "删除一个IAM账号 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class DeleteAccountRequest extends Command {

    @Schema(name = "IAM 用户名称")
    private String userName;
}
