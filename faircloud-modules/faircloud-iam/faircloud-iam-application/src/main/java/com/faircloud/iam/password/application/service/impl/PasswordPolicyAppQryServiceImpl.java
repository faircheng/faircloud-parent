package com.faircloud.iam.password.application.service.impl;

import com.faircloud.iam.password.application.converter.PasswordPolicyAppConverter;
import com.faircloud.iam.password.application.service.PasswordPolicyAppQryService;
import com.faircloud.iam.password.client.module.GetPasswordPolicyResponse;
import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import com.faircloud.iam.password.domain.persistence.PasswordPolicyPersistence;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.platform.common.module.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户密码强度等策略信息 接口实现类
 *
 * @author Fair Cheng
 */
@Service
@RequiredArgsConstructor
public class PasswordPolicyAppQryServiceImpl implements PasswordPolicyAppQryService {

    private final PasswordPolicyPersistence passwordPolicyPersistence;

    @Override
    public Response<GetPasswordPolicyResponse> getPasswordPolicy(Long userId) {
        PasswordPolicyAggregate aggregate = passwordPolicyPersistence.getPasswordPolicy(new UserAggregate(userId));
        return Response.success(PasswordPolicyAppConverter.INSTANCE.to(aggregate));
    }
}
