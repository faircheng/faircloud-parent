package com.faircloud.iam.group.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.IamService;
import com.faircloud.iam.group.client.fallback.GroupClientFallback;
import com.faircloud.iam.group.client.module.AddUserToGroupRequest;
import com.faircloud.iam.group.client.module.CreateGroupRequest;
import com.faircloud.iam.group.client.module.DeleteGroupRequest;
import com.faircloud.iam.group.client.module.GetGroupRequest;
import com.faircloud.iam.group.client.module.GetGroupResponse;
import com.faircloud.iam.group.client.module.ListGroupsForUserRequest;
import com.faircloud.iam.group.client.module.ListGroupsForUserResponse;
import com.faircloud.iam.group.client.module.ListGroupsRequest;
import com.faircloud.iam.group.client.module.ListGroupsResponse;
import com.faircloud.iam.group.client.module.ListUsersForGroupRequest;
import com.faircloud.iam.group.client.module.ListUsersForGroupResponse;
import com.faircloud.iam.group.client.module.UpdateGroupRequest;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 用户组管理 接口
 *
 * @author Felix Cheng
 */
@Tag(name = "用户组管理 接口")
@ApiSort(value = IamService.GROUP)
@FeignClient(name = IamService.NAME, fallbackFactory = GroupClientFallback.class)
public interface GroupClient {

    @Operation(summary = "创建用户组")
    @ApiOperationSupport(order = 1)
    @PostMapping("/groups")
    Response<Void> createGroup(@Valid @RequestBody CreateGroupRequest request);

    @Operation(summary = "查询用户组信息")
    @ApiOperationSupport(order = 2)
    @GetMapping("/groups")
    Response<GetGroupResponse> getGroup(@Valid @RequestBody GetGroupRequest request);

    @Operation(summary = "修改用户组信息")
    @ApiOperationSupport(order = 3)
    @PutMapping("/groups")
    Response<Void> updateGroup(@Valid @RequestBody UpdateGroupRequest request);

    @Operation(summary = "删除指定的用户组")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/groups")
    Response<Void> deleteGroup(@Valid @RequestBody DeleteGroupRequest request);

    @Operation(summary = "查询用户组列表")
    @ApiOperationSupport(order = 5)
    @GetMapping("/groups")
    Response<ListGroupsResponse> listGroups(@Valid @RequestBody ListGroupsRequest request);

    @Operation(summary = "列出指定IAM用户所加入的用户组信息")
    @ApiOperationSupport(order = 6)
    @GetMapping("/list-groups-for-user")
    Response<ListGroupsForUserResponse> listGroupsForUser(@Valid @RequestBody ListGroupsForUserRequest request);

    @Operation(summary = "列出指定用户组所包含的IAM用户")
    @ApiOperationSupport(order = 7)
    @GetMapping("/list-users-for-group")
    Response<ListUsersForGroupResponse> listUsersForGroup(@Valid @RequestBody ListUsersForGroupRequest request);

    @Operation(summary = "将IAM用户添加到指定的用户组")
    @ApiOperationSupport(order = 8)
    @PostMapping("/add-user-to-group")
    Response<Void> addUserToGroup(@Valid @RequestBody AddUserToGroupRequest request);

    @Operation(summary = "将IAM用户从用户组中移除")
    @ApiOperationSupport(order = 9)
    @PostMapping("/remove-user-from-group")
    Response<Void> removeUserFromGroup(@Valid @RequestBody AddUserToGroupRequest request);
}
