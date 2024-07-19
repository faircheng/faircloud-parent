package com.faircloud.iam.password.domain.service.impl;

import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import com.faircloud.iam.password.domain.persistence.PasswordPolicyPersistence;
import com.faircloud.iam.password.domain.service.PasswordPolicyDomainService;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.platform.common.enums.StatusCodeEnum;
import com.faircloud.platform.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 用户密码强度等策略信息 领域接口实现
 *
 * @author Fair Cheng
 */
@Service
@RequiredArgsConstructor
public class PasswordPolicyDomainServiceImpl implements PasswordPolicyDomainService {

    private final PasswordPolicyPersistence passwordPolicyPersistence;

    @Override
    public void valid(String password, UserAggregate user) {
        PasswordPolicyAggregate aggregate = passwordPolicyPersistence.getPasswordPolicy(user);
        if (aggregate == null) {
            aggregate = new PasswordPolicyAggregate();
            aggregate.setDefaultValues();
        }
        // 密码长度校验
        Integer length = StringUtils.length(password);
        if (!(length >= aggregate.getMinimumPasswordLength() && length <= 32)) {
            throw new BusinessException(StatusCodeEnum.A0121);
        }
        // 必须含有小写字母
        if (aggregate.getRequireLowercaseCharacters()) {
            if (!password.matches(".*[a-z].*")) {
                throw new BusinessException(StatusCodeEnum.A0123);
            }
        }
        // 必须含有大写字母
        if (aggregate.getRequireUppercaseCharacters()) {
            if (!password.matches(".*[A-Z].*")) {
                throw new BusinessException(StatusCodeEnum.A0124);
            }
        }
        // 必须含有数字
        if (aggregate.getRequireNumbers()) {
            if (!password.matches(".*[0-9].*")) {
                throw new BusinessException(StatusCodeEnum.A0125);
            }
        }
        // 必须含有特殊字符
        if (aggregate.getRequireSymbols()) {
            if (StringUtils.isAlphanumeric(password)) {
                throw new BusinessException(StatusCodeEnum.A0126);
            }
        }
    }
}
