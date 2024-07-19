package com.faircloud.iam.password.application.service.impl;

import com.faircloud.iam.password.application.converter.PasswordPolicyAppConverter;
import com.faircloud.iam.password.application.service.PasswordPolicyAppCmdService;
import com.faircloud.iam.password.client.module.SetPasswordPolicyRequest;
import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import com.faircloud.iam.password.domain.persistence.PasswordPolicyPersistence;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.platform.common.module.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 用户密码强度等策略信息 接口实现类
 *
 * @author Fair Cheng
 */
@Service
@RequiredArgsConstructor
public class PasswordPolicyAppCmdServiceImpl implements PasswordPolicyAppCmdService {

    private final PasswordPolicyPersistence passwordPolicyPersistence;

    @Override
    public Response setPasswordPolicy(Long userId, SetPasswordPolicyRequest request) {
        PasswordPolicyAggregate aggregate = passwordPolicyPersistence.getPasswordPolicy(new UserAggregate(userId));
        if (aggregate == null) {
            aggregate = PasswordPolicyAppConverter.INSTANCE.to(userId, request);
        } else {
            aggregate = PasswordPolicyAppConverter.INSTANCE.to(request, aggregate);
        }
        passwordPolicyPersistence.save(aggregate);
        return Response.success();
    }
}
