package com.faircloud.iam.password.client.api;

import com.faircloud.iam.password.client.fallback.PasswordPolicyClientFallback;
import com.faircloud.iam.password.client.module.SetPasswordPolicyRequest;
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
 * 用户密码强度等策略信息 接口
 *
 * @author Fair Cheng
 */
@Tag(name = "用户密码强度等策略信息 接口")
@ApiSort(value = 4)
@FeignClient(name = "faircloud-iam-password-policy-service", fallbackFactory = PasswordPolicyClientFallback.class)
public interface PasswordPolicyClient {

    @Operation(summary = "设置IAM用户密码强度等策略信息")
    @ApiOperationSupport(order = 1)
    @PostMapping("/password-policy")
    Response setPasswordPolicy(@Valid @RequestBody SetPasswordPolicyRequest request);

    @Operation(summary = "获取IAM用户密码强度等策略信息")
    @ApiOperationSupport(order = 2)
    @GetMapping("/password-policy")
    Response getPasswordPolicy();
}
