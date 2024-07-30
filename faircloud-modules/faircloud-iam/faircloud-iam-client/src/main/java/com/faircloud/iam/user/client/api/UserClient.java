package com.faircloud.iam.user.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.user.client.fallback.UserClientFallback;
import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.ListUserResponse;
import com.faircloud.iam.user.client.module.LoadUserResponse;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 用户接口
 *
 * @author Fair Cheng
 */
@Tag(name = "用户接口")
@ApiSort(value = 2)
@FeignClient(name = "faircloud-iam-service", fallbackFactory = UserClientFallback.class)
public interface UserClient {

    @Operation(summary = "根据用户名查询用户信息")
    @ApiOperationSupport(order = 1)
    @GetMapping("/users/{userName}")
    @Parameter(name = "userName", description = "用户名", required = true, in = ParameterIn.PATH)
    Response<GetUserResponse> getByUserName(@PathVariable("userName") String userName);

    @Operation(summary = "创建用户")
    @ApiOperationSupport(order = 2)
    @PostMapping("/users")
    Response createUser(@Valid @RequestBody CreateUserRequest request);

    @Operation(summary = "修改用户")
    @ApiOperationSupport(order = 3)
    @PutMapping("/users")
    Response updateUser(@Valid @RequestBody CreateUserRequest request);

    @Operation(summary = "删除一个用户")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/users/{userName}")
    @Parameter(name = "userName", description = "用户名", required = true, in = ParameterIn.PATH)
    Response<Void> deleteUser(@PathVariable("userName") String userName);

    @Operation(summary = "查询所有IAM用户")
    @ApiOperationSupport(order = 5)
    @GetMapping("/users")
    Response<ListUserResponse> listUsers();

    @Operation(summary = "登录用，根据用户名获取用户信息")
    @ApiOperationSupport(order = 6)
    @GetMapping("/users/load/{userName}")
    @Parameter(name = "userName", description = "用户名", required = true, in = ParameterIn.PATH)
    Response<LoadUserResponse> loadUserByUsername(@PathVariable("userName") String userName);
}
