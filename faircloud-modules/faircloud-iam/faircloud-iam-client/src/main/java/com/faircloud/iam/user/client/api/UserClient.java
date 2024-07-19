package com.faircloud.iam.user.client.api;

import com.faircloud.iam.user.client.module.*;
import com.faircloud.iam.user.client.fallback.UserClientFallback;
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
 * 用户接口
 *
 * @author Fair Cheng
 */
@Tag(name = "用户接口")
@ApiSort(value = 2)
@FeignClient(name = "faircloud-iam-user-service", fallbackFactory = UserClientFallback.class)
public interface UserClient {

    @Operation(summary = "根据用户名查询用户信息")
    @ApiOperationSupport(order = 1)
    @GetMapping("/users/{userName}")
    @Parameter(name = "userName", description = "用户名", required = true, in = ParameterIn.PATH)
    Response<GetUserResponse> getUser(@PathVariable("userName") String userName);

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
}
