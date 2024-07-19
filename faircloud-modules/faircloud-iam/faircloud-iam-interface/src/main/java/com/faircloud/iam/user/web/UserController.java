package com.faircloud.iam.user.web;

import com.faircloud.iam.user.application.service.UserAppCmdService;
import com.faircloud.iam.user.application.service.UserAppQryService;
import com.faircloud.iam.user.client.api.UserClient;
import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.ListUserResponse;
import com.faircloud.platform.common.module.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public Response<GetUserResponse> getUser(String userName) {
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
}
