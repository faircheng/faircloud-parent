package com.faircloud.iam.password.application.service;

import com.faircloud.iam.password.client.module.SetPasswordPolicyRequest;
import com.faircloud.platform.common.application.ApplicationCmdService;
import com.faircloud.platform.common.module.Response;

public interface PasswordPolicyAppCmdService extends ApplicationCmdService {

    /**
     * 设置IAM用户密码强度等策略信息
     *
     * @param userId 账号ID
     * @param request 策略
     * @return Response
     */
    Response setPasswordPolicy(Long userId, SetPasswordPolicyRequest request);
}
