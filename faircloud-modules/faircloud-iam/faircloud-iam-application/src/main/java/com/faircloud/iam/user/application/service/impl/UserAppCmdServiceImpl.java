package com.faircloud.iam.user.application.service.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faircloud.iam.user.application.service.UserAppCmdService;
import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.DeleteUserRequest;
import com.faircloud.iam.user.client.module.RegisterAccountRequest;
import com.faircloud.iam.user.client.module.RegisterMobileRequest;
import com.faircloud.iam.user.client.module.UpdateUserRequest;
import com.faircloud.iam.user.domain.event.UserRegisteredEvent;
import com.faircloud.iam.user.domain.factory.UserFactory;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.persistence.UserPersistence;
import com.faircloud.platform.common.module.Response;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAppCmdServiceImpl implements UserAppCmdService {

    private final UserPersistence userPersistence;

    private final ApplicationEventPublisher eventPublisher;

    private final UserFactory userFactory;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response register(RegisterAccountRequest request) {
        // 验证码校验
        if (!"123456".equals(request.getValidationCode())) {
            return Response.fail();
        }
        // 工厂创建领域对象
        UserAggregate aggregate = userFactory.register(request.getUserName(), request.getMobilePhone(), request.getPassword());
        // 保存数据
        userPersistence.save(aggregate);
        // 用户注册事件
        eventPublisher.publishEvent(new UserRegisteredEvent(this, aggregate));
        return Response.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response mobileReg(RegisterMobileRequest request) {
        // 验证码校验
        if (!"123456".equals(request.getValidationCode())) {
            return Response.fail();
        }
        UserAggregate aggregate = userFactory.mobileReg(request.getMobilePhone());
        // 保存用户信息
        userPersistence.save(aggregate);
        // 用户注册事件
        eventPublisher.publishEvent(new UserRegisteredEvent(this, aggregate));
        return Response.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response createUser(CreateUserRequest request, Long userId) {
        // 用户名 校验
        UserAggregate aggregate = userFactory.createUser(userId, request.getUserName(), request.getDisplayName(),
                request.getMobilePhone(), request.getEmail(), request.getComments());
        // 保存数据
        userPersistence.save(aggregate);
        return Response.success();
    }

    @Override
    public Response updateUser(UpdateUserRequest request) {
        return null;
    }

    @Override
    public Response deleteUser(DeleteUserRequest request) {
        return null;
    }

}
