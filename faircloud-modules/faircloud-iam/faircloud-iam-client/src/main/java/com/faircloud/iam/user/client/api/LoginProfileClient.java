package com.faircloud.iam.user.client.api;

import com.faircloud.iam.user.client.fallback.LoginProfileClientFallback;
import com.faircloud.iam.user.client.module.ChangePasswordRequest;
import com.faircloud.iam.user.client.module.CreateLoginProfileRequest;
import com.faircloud.iam.user.client.module.UpdateLoginProfileRequest;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 登录信息接口
 *
 * @author Fair Cheng
 */
@Tag(name = "登录信息接口")
@ApiSort(value = 3)
@FeignClient(name = "faircloud-iam-login-profile-service", fallbackFactory = LoginProfileClientFallback.class)
public interface LoginProfileClient {

    @Operation(summary = "为一个IAM用户启用Web控制台登录")
    @ApiOperationSupport(order = 1)
    @PostMapping("/login-profiles")
    Response createLoginProfile(@Valid @RequestBody CreateLoginProfileRequest request);

    @Operation(summary = "查看一个IAM用户的登录配置")
    @ApiOperationSupport(order = 2)
    @GetMapping("/login-profiles/{userName}")
    @Parameter(name = "userName", description = "用户名", required = true, in = ParameterIn.PATH)
    Response getLoginProfile(@PathVariable("userName") String userName);

    @Operation(summary = "修改用户的登录配置")
    @ApiOperationSupport(order = 3)
    @PutMapping("/login-profiles")
    Response updateLoginProfile(@Valid @RequestBody UpdateLoginProfileRequest request);

    @Operation(summary = "关闭IAM用户登录Web控制台功能")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/login-profiles/{userName}")
    @Parameter(name = "userName", description = "用户名", required = true, in = ParameterIn.PATH)
    Response deleteLoginProfile(@PathVariable("userName") String userName);

    @Operation(summary = "修改IAM用户密码")
    @ApiOperationSupport(order = 5)
    @PostMapping("/login-profiles/change-password")
    Response changePassword(@Valid @RequestBody ChangePasswordRequest request);
}
