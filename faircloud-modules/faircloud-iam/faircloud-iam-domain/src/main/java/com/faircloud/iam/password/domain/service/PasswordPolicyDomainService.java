package com.faircloud.iam.password.domain.service;

import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.platform.common.service.DomainService;

/**
 * 用户密码强度等策略信息 领域接口
 *
 * @author Felix Cheng
 */
public interface PasswordPolicyDomainService extends DomainService {

    /**
     * 校验密码
     *
     * @param password  密码
     * @param aggregate 账号ID
     */
    void valid(String password, UserAggregate aggregate);
}
