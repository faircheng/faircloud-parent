package com.faircloud.iam.settings.client.module;

import com.faircloud.platform.common.module.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 获取全局安全首选项详情 响应参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "获取全局安全首选项详情 响应参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetSecurityPreferenceResponse extends DTO {

    @Schema(name = "访问密钥首选项")
    private GetSecurityPreferenceAccessKeyPreference accessKeyPreference;

    @Schema(name = "多因素认证首选项")
    private GetSecurityPreferenceMFAPreference MFAPreference;

    @Schema(name = "登录首选项")
    private GetSecurityPreferenceLoginProfilePreference loginProfilePreference;

    @Schema(name = "公钥首选项")
    private GetSecurityPreferencePublicKeyPreference publicKeyPreference;

    @Data
    @Builder
    @Schema(description = "获取全局安全首选项详情 访问密钥首选项")
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetSecurityPreferenceAccessKeyPreference extends DTO {

        @Schema(name = "是否允许 IAM 用户自主管理访问密钥")
        private Boolean allowUserToManageAccessKeys;
    }

    @Data
    @Builder
    @Schema(description = "获取全局安全首选项详情 多因素认证首选项")
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetSecurityPreferenceMFAPreference extends DTO {

        @Schema(name = "是否允许 IAM 用户自主管理 MFA 设备")
        private Boolean allowUserToManageMFADevices;
    }

    @Data
    @Builder
    @Schema(description = "获取全局安全首选项详情 登录首选项")
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetSecurityPreferenceLoginProfilePreference extends DTO {

        @Schema(name = "是否允许保存 MFA 验证状态 7 天")
        private Boolean enableSaveMFATicket;

        @Schema(name = "IAM 登录会话的过期时间", description = "小时 （有效值区间为 1 ~ 24 小时）")
        private Integer loginSessionDuration;

        @Schema(name = "登录掩码")
        private String loginNetworkMasks;

        @Schema(name = "是否允许 IAM 用户自主管理密码")
        private Boolean allowUserToChangePassword;
    }

    @Data
    @Builder
    @Schema(description = "获取全局安全首选项详情 公钥首选项")
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetSecurityPreferencePublicKeyPreference extends DTO {

        @Schema(name = "是否允许 IAM 用户自主管理公钥")
        private Boolean allowUserToManagePublicKeys;
    }

}
