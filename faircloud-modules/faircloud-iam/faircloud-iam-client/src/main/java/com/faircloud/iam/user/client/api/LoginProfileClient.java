package com.faircloud.iam.user.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.IamService;
import com.faircloud.iam.user.client.fallback.LoginProfileClientFallback;
import com.faircloud.iam.user.client.module.ChangePasswordRequest;
import com.faircloud.iam.user.client.module.CreateLoginProfileRequest;
import com.faircloud.iam.user.client.module.DeleteLoginProfileRequest;
import com.faircloud.iam.user.client.module.GetLoginProfileRequest;
import com.faircloud.iam.user.client.module.UpdateLoginProfileRequest;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 登录信息 接口
 *
 * @author Felix Cheng
 */
@Tag(name = "登录信息 接口")
@ApiSort(value = IamService.LOGIN_PROFILE)
@FeignClient(name = IamService.NAME, fallbackFactory = LoginProfileClientFallback.class)
public interface LoginProfileClient {

    @Operation(summary = "为一个IAM用户启用Web控制台登录")
    @ApiOperationSupport(order = 1)
    @PostMapping("/login-profiles")
    Response createLoginProfile(@Valid @RequestBody CreateLoginProfileRequest request);

    @Operation(summary = "查看一个IAM用户的登录配置")
    @ApiOperationSupport(order = 2)
    @GetMapping("/login-profiles")
    Response getLoginProfile(@Valid @RequestBody GetLoginProfileRequest request);

    @Operation(summary = "修改用户的登录配置")
    @ApiOperationSupport(order = 3)
    @PutMapping("/login-profiles")
    Response updateLoginProfile(@Valid @RequestBody UpdateLoginProfileRequest request);

    @Operation(summary = "关闭IAM用户登录Web控制台功能")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/login-profiles")
    Response deleteLoginProfile(@Valid @RequestBody DeleteLoginProfileRequest request);

    @Operation(summary = "修改IAM用户密码")
    @ApiOperationSupport(order = 5)
    @PostMapping("/login-profiles/change-password")
    Response changePassword(@Valid @RequestBody ChangePasswordRequest request);
}
