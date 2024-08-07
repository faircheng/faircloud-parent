package com.faircloud.iam.authority.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.IamService;
import com.faircloud.iam.authority.client.fallback.PermissionClientFallback;
import com.faircloud.iam.authority.client.module.AttachPolicyToGroupRequest;
import com.faircloud.iam.authority.client.module.AttachPolicyToRoleRequest;
import com.faircloud.iam.authority.client.module.AttachPolicyToUserRequest;
import com.faircloud.iam.authority.client.module.DetachPolicyFromGroupRequest;
import com.faircloud.iam.authority.client.module.DetachPolicyFromUserRequest;
import com.faircloud.iam.authority.client.module.ListEntitiesForPolicyRequest;
import com.faircloud.iam.authority.client.module.ListEntitiesForPolicyResponse;
import com.faircloud.iam.authority.client.module.ListPoliciesForGroupRequest;
import com.faircloud.iam.authority.client.module.ListPoliciesForGroupResponse;
import com.faircloud.iam.authority.client.module.ListPoliciesForRoleRequest;
import com.faircloud.iam.authority.client.module.ListPoliciesForRoleResponse;
import com.faircloud.iam.authority.client.module.ListPoliciesForUserRequest;
import com.faircloud.iam.authority.client.module.ListPoliciesForUserResponse;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 授权管理 接口
 *
 * @author Felix Cheng
 */
@Tag(name = "授权管理 接口")
@ApiSort(value = IamService.PERMISSION)
@FeignClient(name = IamService.NAME, fallbackFactory = PermissionClientFallback.class)
public interface PermissionClient {

    @Operation(summary = "为指定用户添加权限")
    @ApiOperationSupport(order = 1)
    @PostMapping("/attach-policy-to-user")
    Response<Void> attachPolicyToUser(@Valid @RequestBody AttachPolicyToUserRequest request);

    @Operation(summary = "为用户撤销指定的权限")
    @ApiOperationSupport(order = 2)
    @DeleteMapping("/detach-policy-from-user")
    Response<Void> detachPolicyFromUser(@Valid @RequestBody DetachPolicyFromUserRequest request);

    @Operation(summary = "为指定用户组添加权限")
    @ApiOperationSupport(order = 3)
    @PostMapping("/attach-policy-to-group")
    Response<Void> attachPolicyToGroup(@Valid @RequestBody AttachPolicyToGroupRequest request);

    @Operation(summary = "为用户撤销指定的权限")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/detach-policy-from-group")
    Response<Void> detachPolicyFromGroup(@Valid @RequestBody DetachPolicyFromGroupRequest request);

    @Operation(summary = "为指定角色添加权限")
    @ApiOperationSupport(order = 5)
    @PostMapping("/attach-policy-to-role")
    Response<Void> attachPolicyToRole(@Valid @RequestBody AttachPolicyToRoleRequest request);

    @Operation(summary = "为角色撤销指定的权限")
    @ApiOperationSupport(order = 6)
    @DeleteMapping("/detach-policy-from-role")
    Response<Void> detachPolicyFromRole(@Valid @RequestBody DetachPolicyFromGroupRequest request);

    @Operation(summary = "查询IAM用户的授权列表")
    @ApiOperationSupport(order = 7)
    @GetMapping("/list-policies-for-user")
    Response<ListPoliciesForUserResponse> listPoliciesForUser(@Valid @RequestBody ListPoliciesForUserRequest request);

    @Operation(summary = "列出用户组的权限策略")
    @ApiOperationSupport(order = 8)
    @GetMapping("/list-policies-for-group")
    Response<ListPoliciesForGroupResponse> listPoliciesForGroup(@Valid @RequestBody ListPoliciesForGroupRequest request);

    @Operation(summary = "列出角色的权限策略")
    @ApiOperationSupport(order = 9)
    @GetMapping("/list-policies-for-role")
    Response<ListPoliciesForRoleResponse> listPoliciesForRole(@Valid @RequestBody ListPoliciesForRoleRequest request);

    @Operation(summary = "列出引用权限策略的实体")
    @ApiOperationSupport(order = 10)
    @GetMapping("/list-entities-for-policy")
    Response<ListEntitiesForPolicyResponse> listEntitiesForPolicy(@Valid @RequestBody ListEntitiesForPolicyRequest request);
}
