package com.faircloud.iam.user.web;

import org.springframework.web.bind.annotation.RestController;

import com.faircloud.iam.user.application.service.UserAppCmdService;
import com.faircloud.iam.user.application.service.UserAppQryService;
import com.faircloud.iam.user.client.api.UserClient;
import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.ListUserResponse;
import com.faircloud.iam.user.client.module.LoadUserResponse;
import com.faircloud.platform.common.module.Response;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户控制器
 *
 * @author Fair Cheng
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserClient {

    private final UserAppCmdService userAppCmdService;

    private final UserAppQryService userAppQryService;

    private final HttpServletRequest request;

    @Override
    public Response<GetUserResponse> getByUserName(String userName) {
        return userAppQryService.getByUserName(userName);
    }

    @Override
    public Response createUser(CreateUserRequest request) {
        return userAppCmdService.createUser(request);
    }

    @Override
    public Response updateUser(CreateUserRequest request) {
        return userAppCmdService.updateUser(request);
    }

    @Override
    public Response<Void> deleteUser(String userName) {
        return userAppCmdService.deleteUser(userName);
    }

    @Override
    public Response<ListUserResponse> listUsers() {
        return userAppQryService.listUsers();
    }

    @Override
    public Response<LoadUserResponse> loadUserByUsername(String userName) {
        return userAppQryService.loadUserByUsername(userName);
    }
}
