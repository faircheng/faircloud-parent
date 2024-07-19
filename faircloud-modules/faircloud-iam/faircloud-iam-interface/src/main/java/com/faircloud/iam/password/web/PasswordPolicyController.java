package com.faircloud.iam.password.web;

import com.faircloud.iam.password.application.service.PasswordPolicyAppCmdService;
import com.faircloud.iam.password.application.service.PasswordPolicyAppQryService;
import com.faircloud.iam.password.client.api.PasswordPolicyClient;
import com.faircloud.iam.password.client.module.SetPasswordPolicyRequest;
import com.faircloud.iam.user.application.service.UserAppCmdService;
import com.faircloud.iam.user.application.service.UserAppQryService;
import com.faircloud.iam.user.client.api.AccountClient;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.RegisterAccountRequest;
import com.faircloud.iam.user.client.module.RegisterMobileRequest;
import com.faircloud.platform.common.module.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户密码强度等策略信息 前端控制器
 *
 * @author Fair Cheng
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class PasswordPolicyController implements PasswordPolicyClient {

    private final PasswordPolicyAppCmdService passwordPolicyAppCmdService;

    private final PasswordPolicyAppQryService passwordPolicyAppQryService;

    @Override
    public Response setPasswordPolicy(SetPasswordPolicyRequest request) {
        return passwordPolicyAppCmdService.setPasswordPolicy(1L, request);
    }

    @Override
    public Response getPasswordPolicy() {
        return passwordPolicyAppQryService.getPasswordPolicy(1L);
    }
}
