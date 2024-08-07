package com.faircloud.iam.password.infrastructure.persistence;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import com.faircloud.iam.password.domain.persistence.PasswordPolicyPersistence;
import com.faircloud.iam.password.infrastructure.persistence.converter.PasswordPolicyConverter;
import com.faircloud.iam.password.infrastructure.persistence.mapper.PasswordPolicyMapper;
import com.faircloud.iam.password.infrastructure.persistence.po.PasswordPolicy;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用户密码强度等策略信息 适配器
 *
 * @author Felix Cheng
 */
@Component
@RequiredArgsConstructor
public class PasswordPolicyAdapter implements PasswordPolicyPersistence {

    private final PasswordPolicyMapper passwordPolicyMapper;

    @Override
    public PasswordPolicyAggregate getPasswordPolicy(UserAggregate aggregate) {
        PasswordPolicy passwordPolicy = passwordPolicyMapper.selectOne(new LambdaQueryWrapper<PasswordPolicy>().eq(PasswordPolicy::getUserId, aggregate.getId()));
        return PasswordPolicyConverter.INSTANCE.to(passwordPolicy);
    }

    @Override
    public void save(PasswordPolicyAggregate aggregate) {
        passwordPolicyMapper.insertOrUpdate(PasswordPolicyConverter.INSTANCE.to(aggregate));
    }
}
