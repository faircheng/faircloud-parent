package com.faircloud.iam.user.infrastructure.persistence;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.entity.LoginProfileEntity;
import com.faircloud.iam.user.domain.persistence.LoginProfilePersistence;
import com.faircloud.iam.user.infrastructure.persistence.converter.UserConverter;
import com.faircloud.iam.user.infrastructure.persistence.mapper.LoginProfileMapper;
import com.faircloud.iam.user.infrastructure.persistence.po.LoginProfile;
import com.faircloud.platform.common.exception.Assert;

import lombok.RequiredArgsConstructor;

/**
 * 登录信息 仓储适配器
 *
 * @author Felix Cheng
 */
@Component
@RequiredArgsConstructor
public class LoginProfileAdapter implements LoginProfilePersistence {

    private final LoginProfileMapper loginProfileMapper;

    @Override
    public LoginProfileEntity getByUserId(UserAggregate user) {
        LoginProfile profile = loginProfileMapper.selectOne(new LambdaQueryWrapper<LoginProfile>().eq(LoginProfile::getUserId, user.getId()));
        Assert.notNull(profile);
        return UserConverter.INSTANCE.to(profile);
    }
}
