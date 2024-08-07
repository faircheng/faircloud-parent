package com.faircloud.iam.user.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.IamService;
import com.faircloud.iam.user.client.fallback.UserClientFallback;
import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.DeleteUserRequest;
import com.faircloud.iam.user.client.module.GetUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.ListUserResponse;
import com.faircloud.iam.user.client.module.ListUsersRequest;
import com.faircloud.iam.user.client.module.LoadUserByUsernameRequest;
import com.faircloud.iam.user.client.module.LoadUserResponse;
import com.faircloud.iam.user.client.module.UpdateUserRequest;
import com.faircloud.platform.common.module.PageResult;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 用户管理 接口
 *
 * @author Felix Cheng
 */
@Tag(name = "用户管理 接口")
@ApiSort(value = IamService.USER)
@FeignClient(name = IamService.NAME, fallbackFactory = UserClientFallback.class)
public interface UserClient {

    @Operation(summary = "创建IAM用户")
    @ApiOperationSupport(order = 1)
    @PostMapping("/users")
    Response createUser(@Valid @RequestBody CreateUserRequest request);

    @Operation(summary = "查询IAM用户的详细信息")
    @ApiOperationSupport(order = 2)
    @GetMapping("/users")
    Response<GetUserResponse> getUser(@Valid @SpringQueryMap GetUserRequest request);

    @Operation(summary = "更新IAM用户的基本信息")
    @ApiOperationSupport(order = 3)
    @PutMapping("/users")
    Response updateUser(@Valid @RequestBody UpdateUserRequest request);

    @Operation(summary = "删除一个IAM用户")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/users")
    Response<Void> deleteUser(@Valid @RequestBody DeleteUserRequest request);

    @Operation(summary = "查询所有IAM用户")
    @ApiOperationSupport(order = 5)
    @GetMapping("/users/page")
    Response<PageResult<ListUserResponse>> listUsers(@Valid @SpringQueryMap ListUsersRequest request);

    @Operation(summary = "登录用，根据用户名获取用户信息", hidden = true)
    @ApiOperationSupport(order = 6)
    @GetMapping("/load-user")
    Response<LoadUserResponse> loadUserByUsername(@Valid @SpringQueryMap LoadUserByUsernameRequest request);
}
