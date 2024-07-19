package com.faircloud.iam.user.infrastructure.persistence;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.entity.LoginProfileEntity;
import com.faircloud.iam.user.domain.model.entity.UserInfoEntity;
import com.faircloud.iam.user.domain.model.valueobject.MobilePhone;
import com.faircloud.iam.user.domain.persistence.UserPersistence;
import com.faircloud.iam.user.infrastructure.persistence.converter.UserInfraConverter;
import com.faircloud.iam.user.infrastructure.persistence.mapper.LoginProfileMapper;
import com.faircloud.iam.user.infrastructure.persistence.mapper.UserInfoMapper;
import com.faircloud.iam.user.infrastructure.persistence.mapper.UserMapper;
import com.faircloud.iam.user.infrastructure.persistence.po.LoginProfile;
import com.faircloud.iam.user.infrastructure.persistence.po.User;
import com.faircloud.iam.user.infrastructure.persistence.po.UserInfo;
import com.faircloud.platform.common.exception.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户仓储适配器
 *
 * @author Fair Cheng
 */
@Component
@RequiredArgsConstructor
public class UserAdapter implements UserPersistence {

    private final UserMapper userMapper;

    private final LoginProfileMapper loginProfileMapper;

    private final UserInfoMapper userInfoMapper;

    @Override
    public void save(UserAggregate aggregate) {
        User user = UserInfraConverter.INSTANCE.to(aggregate);
        userMapper.insert(user);

        LoginProfile loginProfile = UserInfraConverter.INSTANCE.to(aggregate.getLoginProfile());
        loginProfileMapper.insert(loginProfile);

        UserInfo userInfo = UserInfraConverter.INSTANCE.to(aggregate.getUserInfo());
        userInfoMapper.insert(userInfo);
    }

    @Override
    public UserAggregate getById(Long id) {
        User user = userMapper.selectById(id);
        return UserInfraConverter.INSTANCE.to(user);
    }

    @Override
    public UserAggregate getByUserName(String userName) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, userName));
        return UserInfraConverter.INSTANCE.to(user);
    }

    @Override
    public UserAggregate getByMobilePhone(String mobilePhone) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getMobilePhone, mobilePhone));
        return UserInfraConverter.INSTANCE.to(user);
    }

    @Override
    public UserAggregate loadUserByUsername(String username) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, username));
        Assert.notNull(user, "");
        LoginProfile loginProfile = loginProfileMapper.selectOne(new LambdaQueryWrapper<LoginProfile>().eq(LoginProfile::getUserId, user.getId()));
        Assert.notNull(loginProfile, "");
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserId, user.getId()));
        Assert.notNull(userInfo, "");
        UserAggregate aggregate = UserInfraConverter.INSTANCE.to(user, loginProfile, userInfo);
        return aggregate;
    }

    @Override
    public List<UserAggregate> listUsers() {
        List<User> list = userMapper.selectList(new LambdaQueryWrapper<>());
        return UserInfraConverter.INSTANCE.to(list);
    }

    @Override
    public Boolean checkUserName(String userName, Long id) {
        UserAggregate aggregate = this.getByUserName(userName);
        if (aggregate != null && !aggregate.getId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkMobilePhone(MobilePhone mobilePhone, Long id) {
        UserAggregate aggregate = this.getByMobilePhone(mobilePhone.getMobilePhone());
        if (aggregate != null && !aggregate.getId().equals(id)) {
            return true;
        }
        return false;
    }
}
