package com.faircloud.iam.settings.client.module;

import com.faircloud.platform.common.module.Command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 设置全局安全首选项 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "设置全局安全首选项 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SetSecurityPreferenceRequest extends Command {

    @Schema(name = "是否允许保存 MFA 验证状态 7 天")
    private Boolean enableSaveMFATicket;

    @Schema(name = "是否允许 IAM 用户自主管理密码")
    private Boolean allowUserToChangePassword;

    @Schema(name = "是否允许 IAM 用户自主管理访问密钥")
    private Boolean allowUserToManageAccessKeys;

    @Schema(name = "是否允许 IAM 用户自主管理公钥")
    private Boolean allowUserToManagePublicKeys;

    @Schema(name = "是否允许 IAM 用户自主管理 MFA 设备")
    private Boolean allowUserToManageMFADevices;

    @Min(value = 1)
    @Max(value = 24)
    @Schema(name = "IAM 登录会话的过期时间", description = "小时 （有效值区间为 1 ~ 24 小时）")
    private Integer loginSessionDuration;

    @Schema(name = "登录掩码", description = "登录掩码。登录掩码决定哪些 IP 地址会受到登录控制台的影响，包括密码登录和单点登录（SSO），但使用访问密钥发起的 API 调用并不受影响。\n" +
        "\n" +
        "如果指定掩码，RAM 用户只能从指定的 IP 地址进行登录。\n" +
        "如果不指定任何掩码，登录控制台功能将适用于整个网络。\n" +
        "当需要配置多个登录掩码时，请使用分号（;）来分隔，例如：192.168.0.0/16;10.0.0.0/8。\n" +
        "\n" +
        "最多配置 25 个登录掩码，总长度最大 512 个字符。")
    private String loginNetworkMasks;
}
