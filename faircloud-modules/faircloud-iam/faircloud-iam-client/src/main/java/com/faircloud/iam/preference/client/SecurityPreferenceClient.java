package com.faircloud.iam.preference.client;

import com.faircloud.iam.password.client.fallback.PasswordPolicyClientFallback;
import com.faircloud.iam.password.client.module.SetPasswordPolicyRequest;
import com.faircloud.iam.user.client.module.DeleteAccessKeyRequest;
import com.faircloud.iam.user.client.module.GetAccessKeyRequest;
import com.faircloud.iam.user.client.module.UpdateAccessKeyRequest;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 安全设置 接口
 *
 * @author Fair Cheng
 */
@Tag(name = "安全设置 接口")
@ApiSort(value = 4)
@FeignClient(name = "faircloud-iam-security-preference-service", fallbackFactory = PasswordPolicyClientFallback.class)
public interface SecurityPreferenceClient {

    @Operation(summary = "设置全局安全首选项")
    @ApiOperationSupport(order = 1)
    @PostMapping("/security-preference")
    Response setSecurityPreference(@Valid @RequestBody DeleteAccessKeyRequest request);

    @Operation(summary = "获取全局安全首选项详情")
    @ApiOperationSupport(order = 2)
    @GetMapping("/security-preference")
    Response getSecurityPreference();
}
