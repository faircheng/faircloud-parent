package com.faircloud.iam.user.infrastructure.persistence;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.valueobject.MobilePhone;
import com.faircloud.iam.user.domain.persistence.UserPersistence;
import com.faircloud.iam.user.infrastructure.persistence.converter.UserConverter;
import com.faircloud.iam.user.infrastructure.persistence.mapper.LoginProfileMapper;
import com.faircloud.iam.user.infrastructure.persistence.mapper.UserInfoMapper;
import com.faircloud.iam.user.infrastructure.persistence.mapper.UserMapper;
import com.faircloud.iam.user.infrastructure.persistence.po.LoginProfile;
import com.faircloud.iam.user.infrastructure.persistence.po.User;
import com.faircloud.iam.user.infrastructure.persistence.po.UserInfo;
import com.faircloud.platform.common.exception.Assert;
import com.faircloud.platform.common.module.PageQuery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户仓储适配器
 *
 * @author Felix Cheng
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserAdapter implements UserPersistence {

    private final UserMapper userMapper;

    private final LoginProfileMapper loginProfileMapper;

    private final UserInfoMapper userInfoMapper;

    @Override
    public void save(UserAggregate aggregate) {
        User user = UserConverter.INSTANCE.to(aggregate);
        userMapper.insert(user);

        LoginProfile loginProfile = UserConverter.INSTANCE.to(aggregate.getLoginProfile());
        loginProfileMapper.insert(loginProfile);

        UserInfo userInfo = UserConverter.INSTANCE.to(aggregate.getUserInfo());
        userInfoMapper.insert(userInfo);
    }

    @Override
    public UserAggregate getById(Long id) {
        User user = userMapper.selectById(id);
        return UserConverter.INSTANCE.to(user);
    }

    @Override
    public UserAggregate getByUserName(String userName) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, userName));
        return UserConverter.INSTANCE.to(user);
    }

    @Override
    public UserAggregate getByMobilePhone(String mobilePhone) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getMobilePhone, mobilePhone));
        return UserConverter.INSTANCE.to(user);
    }

    @Override
    public UserAggregate loadUserByUsername(String username) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getEnabled, true).eq(User::getUserName, username));
        Assert.notNull(user);
        LoginProfile loginProfile = loginProfileMapper.selectOne(new LambdaQueryWrapper<LoginProfile>().eq(LoginProfile::getUserId, user.getId()));
        Assert.notNull(loginProfile);
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserId, user.getId()));
        Assert.notNull(userInfo);
        UserAggregate aggregate = UserConverter.INSTANCE.to(user, loginProfile, userInfo);
        return aggregate;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<UserAggregate> listUsers(UserAggregate query, PageQuery pageQuery) {
        User user = UserConverter.INSTANCE.to(query);
        Page<User> page = new Page<>(pageQuery.getPageNumber(), pageQuery.getPageSize());
        Page<User> list = userMapper.listUsers(page, user);
        return null;
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
