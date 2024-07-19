package com.faircloud.iam.password.application.service;

import com.faircloud.iam.password.client.module.GetPasswordPolicyResponse;
import com.faircloud.platform.common.application.ApplicationQryService;
import com.faircloud.platform.common.module.Response;

public interface PasswordPolicyAppQryService extends ApplicationQryService {

    /**
     * 获取IAM用户密码强度等策略信息
     *
     * @param userId 账号ID
     * @return 用户密码强度等策略信息
     */
    Response<GetPasswordPolicyResponse> getPasswordPolicy(Long userId);
}
