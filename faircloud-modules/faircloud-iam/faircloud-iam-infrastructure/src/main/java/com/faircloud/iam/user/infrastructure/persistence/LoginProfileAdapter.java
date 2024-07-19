package com.faircloud.iam.user.infrastructure.persistence;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.entity.LoginProfileEntity;
import com.faircloud.iam.user.domain.persistence.LoginProfilePersistence;
import com.faircloud.iam.user.infrastructure.persistence.converter.UserInfraConverter;
import com.faircloud.iam.user.infrastructure.persistence.mapper.LoginProfileMapper;
import com.faircloud.iam.user.infrastructure.persistence.po.LoginProfile;
import com.faircloud.platform.common.exception.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 登录信息 仓储适配器
 *
 * @author Fair Cheng
 */
@Component
@RequiredArgsConstructor
public class LoginProfileAdapter implements LoginProfilePersistence {

    private final LoginProfileMapper loginProfileMapper;

    @Override
    public LoginProfileEntity getByUserId(UserAggregate user) {
        LoginProfile profile = loginProfileMapper.selectOne(new LambdaQueryWrapper<LoginProfile>().eq(LoginProfile::getUserId, user.getId()));
        Assert.notNull(profile, "");
        return UserInfraConverter.INSTANCE.to(profile);
    }
}
