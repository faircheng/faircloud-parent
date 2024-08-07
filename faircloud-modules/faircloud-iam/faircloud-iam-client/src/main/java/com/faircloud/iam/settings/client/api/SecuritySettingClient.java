package com.faircloud.iam.settings.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.IamService;
import com.faircloud.iam.settings.client.fallback.SecuritySettingClientFallback;
import com.faircloud.iam.settings.client.module.GetAccountAliasResponse;
import com.faircloud.iam.settings.client.module.GetSecurityPreferenceResponse;
import com.faircloud.iam.settings.client.module.SetAccountAliasRequest;
import com.faircloud.iam.settings.client.module.SetPasswordPolicyRequest;
import com.faircloud.iam.settings.client.module.SetSecurityPreferenceRequest;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 安全设置 接口
 *
 * @author Felix Cheng
 */
@Tag(name = "安全设置 接口")
@ApiSort(value = IamService.SETTING)
@FeignClient(name = IamService.NAME, fallbackFactory = SecuritySettingClientFallback.class)
public interface SecuritySettingClient {

    @Operation(summary = "设置云账号别名")
    @ApiOperationSupport(order = 1)
    @PostMapping("/account-alias")
    Response<Void> setAccountAlias(@Valid @RequestBody SetAccountAliasRequest request);

    @Operation(summary = "查看云账号别名")
    @ApiOperationSupport(order = 2)
    @GetMapping("/account-alias")
    Response<GetAccountAliasResponse> getAccountAlias();

    @Operation(summary = "清除云账号别名")
    @ApiOperationSupport(order = 3)
    @DeleteMapping("/account-alias")
    Response<Void> clearAccountAlias();

    @Operation(summary = "设置IAM用户密码强度等策略信息")
    @ApiOperationSupport(order = 4)
    @PostMapping("/password-policy")
    Response<Void> setPasswordPolicy(@Valid @RequestBody SetPasswordPolicyRequest request);

    @Operation(summary = "获取IAM用户密码强度等策略信息")
    @ApiOperationSupport(order = 5)
    @GetMapping("/password-policy")
    Response<Void> getPasswordPolicy();

    @Operation(summary = "设置全局安全首选项")
    @ApiOperationSupport(order = 6)
    @PostMapping("/security-preference")
    Response<Void> setSecurityPreference(@Valid @RequestBody SetSecurityPreferenceRequest request);

    @Operation(summary = "获取全局安全首选项详情")
    @ApiOperationSupport(order = 7)
    @GetMapping("/security-preference")
    Response<GetSecurityPreferenceResponse> getSecurityPreference();
}
