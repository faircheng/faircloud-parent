package com.faircloud.iam.role.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.IamService;
import com.faircloud.iam.group.client.module.ListGroupsResponse;
import com.faircloud.iam.role.client.fallback.RoleClientFallback;
import com.faircloud.iam.role.client.module.CreateRoleRequest;
import com.faircloud.iam.role.client.module.DeleteRoleRequest;
import com.faircloud.iam.role.client.module.GetRoleRequest;
import com.faircloud.iam.role.client.module.GetRoleResponse;
import com.faircloud.iam.role.client.module.ListRolesRequest;
import com.faircloud.iam.role.client.module.UpdateRoleRequest;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 角色管理 接口
 *
 * @author Felix Cheng
 */
@Tag(name = "角色管理 接口")
@ApiSort(value = IamService.ROLE)
@FeignClient(name = IamService.NAME, fallbackFactory = RoleClientFallback.class)
public interface RoleClient {

    @Operation(summary = "创建角色")
    @ApiOperationSupport(order = 1)
    @PostMapping("/roles")
    Response<Void> createRole(@Valid @RequestBody CreateRoleRequest request);

    @Operation(summary = "获取角色信息")
    @ApiOperationSupport(order = 2)
    @GetMapping("/roles")
    Response<GetRoleResponse> getRole(@Valid @RequestBody GetRoleRequest request);

    @Operation(summary = "更新角色信息")
    @ApiOperationSupport(order = 3)
    @PutMapping("/roles")
    Response<Void> updateRole(@Valid @RequestBody UpdateRoleRequest request);

    @Operation(summary = "删除指定的角色")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/roles")
    Response<Void> deleteRole(@Valid @RequestBody DeleteRoleRequest request);

    @Operation(summary = "获取角色列表")
    @ApiOperationSupport(order = 5)
    @GetMapping("/roles")
    Response<ListGroupsResponse> listRoles(@Valid @RequestBody ListRolesRequest request);
}
