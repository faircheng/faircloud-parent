package com.faircloud.iam.user.web;

import org.springframework.web.bind.annotation.RestController;

import com.faircloud.iam.user.application.service.UserAppCmdService;
import com.faircloud.iam.user.application.service.UserAppQryService;
import com.faircloud.iam.user.client.api.UserClient;
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
import com.faircloud.platform.common.util.SecurityUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户控制器
 *
 * @author Felix Cheng
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserClient {

    private final UserAppCmdService userAppCmdService;

    private final UserAppQryService userAppQryService;

    @Override
    public Response<GetUserResponse> getUser(GetUserRequest request) {
        log.info("user id:", SecurityUtils.getUserId());
        return userAppQryService.getUser(request);
    }

    @Override
    public Response createUser(CreateUserRequest request) {

        return userAppCmdService.createUser(request, SecurityUtils.getUserId());
    }

    @Override
    public Response updateUser(UpdateUserRequest request) {
        return userAppCmdService.updateUser(request);
    }

    @Override
    public Response<Void> deleteUser(DeleteUserRequest request) {
        return userAppCmdService.deleteUser(request);
    }

    @Override
    public Response<PageResult<ListUserResponse>> listUsers(ListUsersRequest request) {
        return userAppQryService.listUsers(request);
    }

    @Override
    public Response<LoadUserResponse> loadUserByUsername(LoadUserByUsernameRequest request) {
        return userAppQryService.loadUserByUsername(request.getUserName());
    }
}
