package com.faircloud.iam.user.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.user.client.fallback.AccountClientFallback;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.RegisterAccountRequest;
import com.faircloud.iam.user.client.module.RegisterMobileRequest;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 账号接口
 *
 * @author Fair Cheng
 */
@Tag(name = "账号接口")
@ApiSort(value = 1)
@FeignClient(name = "faircloud-iam-service", fallbackFactory = AccountClientFallback.class)
public interface AccountClient {

    @Operation(summary = "手机号注册")
    @ApiOperationSupport(order = 1)
    @PostMapping("/mobile-reg")
    Response mobileReg(@Valid @RequestBody RegisterMobileRequest request);

    @Operation(summary = "账号密码注册")
    @ApiOperationSupport(order = 2)
    @PostMapping("/register")
    Response register(@Valid @RequestBody RegisterAccountRequest request);

    @Operation(summary = "根据用户名查询账号信息")
    @ApiOperationSupport(order = 3)
    @GetMapping("/account/{userName}")
    @Parameter(name = "userName", description = "用户名", required = true, in = ParameterIn.PATH)
    Response<GetUserResponse> getByUserName(@PathVariable("userName") String userName);

    @Operation(summary = "账号注销")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/account/{userName}")
    @Parameter(name = "userName", description = "用户名", required = true, in = ParameterIn.PATH)
    Response<Void> cancellation(@PathVariable("userName") String userName);

}
