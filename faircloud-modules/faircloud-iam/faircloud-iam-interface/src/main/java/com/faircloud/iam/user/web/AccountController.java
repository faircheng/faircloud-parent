package com.faircloud.iam.user.web;

import com.faircloud.iam.user.application.service.UserAppCmdService;
import com.faircloud.iam.user.application.service.UserAppQryService;
import com.faircloud.iam.user.client.api.AccountClient;
import com.faircloud.iam.user.client.api.UserClient;
import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.RegisterAccountRequest;
import com.faircloud.iam.user.client.module.RegisterMobileRequest;
import com.faircloud.platform.common.module.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账号控制器
 *
 * @author Fair Cheng
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountController implements AccountClient {

    private final UserAppCmdService userAppCmdService;

    private final UserAppQryService userAppQryService;

    @Override
    public Response mobileReg(RegisterMobileRequest request) {

        return userAppCmdService.mobileReg(request);
    }

    @Override
    public Response register(RegisterAccountRequest request) {

        return userAppCmdService.register(request);
    }

    @Override
    public Response<GetUserResponse> getByUserName(String userName) {

        return userAppQryService.getByUserName(userName);
    }

    @Override
    public Response<Void> cancellation(String userName) {
        // TODO 有点复杂
        return null;
    }
}
