package com.faircloud.iam.settings.web;

import org.springframework.web.bind.annotation.RestController;

import com.faircloud.iam.password.application.service.PasswordPolicyAppCmdService;
import com.faircloud.iam.password.application.service.PasswordPolicyAppQryService;
import com.faircloud.iam.settings.client.api.SecuritySettingClient;
import com.faircloud.iam.settings.client.module.GetAccountAliasResponse;
import com.faircloud.iam.settings.client.module.SetAccountAliasRequest;
import com.faircloud.iam.settings.client.module.SetPasswordPolicyRequest;
import com.faircloud.iam.settings.client.module.SetSecurityPreferenceRequest;
import com.faircloud.platform.common.module.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户密码强度等策略信息 前端控制器
 *
 * @author Felix Cheng
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class SecuritySettingController implements SecuritySettingClient {

    private final PasswordPolicyAppCmdService passwordPolicyAppCmdService;

    private final PasswordPolicyAppQryService passwordPolicyAppQryService;

    @Override
    public Response setAccountAlias(SetAccountAliasRequest request) {
        return null;
    }

    @Override
    public Response<GetAccountAliasResponse> getAccountAlias() {
        return null;
    }

    @Override
    public Response<Void> clearAccountAlias() {
        return null;
    }

    @Override
    public Response setPasswordPolicy(SetPasswordPolicyRequest request) {
        return passwordPolicyAppCmdService.setPasswordPolicy(1L, request);
    }

    @Override
    public Response getPasswordPolicy() {
        return passwordPolicyAppQryService.getPasswordPolicy(1L);
    }

    @Override
    public Response setSecurityPreference(SetSecurityPreferenceRequest request) {
        return null;
    }

    @Override
    public Response getSecurityPreference() {
        return null;
    }
}
