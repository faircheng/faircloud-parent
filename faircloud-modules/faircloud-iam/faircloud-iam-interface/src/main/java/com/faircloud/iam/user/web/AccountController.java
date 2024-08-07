package com.faircloud.iam.user.web;

import org.springframework.web.bind.annotation.RestController;

import com.faircloud.iam.user.application.service.UserAppCmdService;
import com.faircloud.iam.user.application.service.UserAppQryService;
import com.faircloud.iam.user.client.api.AccountClient;
import com.faircloud.iam.user.client.module.DeleteAccountRequest;
import com.faircloud.iam.user.client.module.GetUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.RegisterAccountRequest;
import com.faircloud.iam.user.client.module.RegisterMobileRequest;
import com.faircloud.platform.common.module.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 账号控制器
 *
 * @author Felix Cheng
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
    public Response<GetUserResponse> getAccount(GetUserRequest request) {

        return userAppQryService.getUser(request);
    }

    @Override
    public Response<Void> cancellation(DeleteAccountRequest request) {
        // TODO 有点复杂
        return null;
    }
}
