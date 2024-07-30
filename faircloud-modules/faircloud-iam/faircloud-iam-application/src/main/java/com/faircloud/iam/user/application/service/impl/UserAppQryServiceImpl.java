package com.faircloud.iam.user.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faircloud.iam.user.application.converter.UserAppConverter;
import com.faircloud.iam.user.application.service.UserAppQryService;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.ListUserResponse;
import com.faircloud.iam.user.client.module.LoadUserResponse;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.persistence.UserPersistence;
import com.faircloud.platform.common.module.Response;

import lombok.RequiredArgsConstructor;

/**
 * user application query service impl
 *
 * @author Fair Cheng
 */
@Service
@RequiredArgsConstructor
public class UserAppQryServiceImpl implements UserAppQryService {

    private final UserPersistence userPersistence;

    @Override
    public Response<GetUserResponse> getById(Long id) {
        UserAggregate aggregate = userPersistence.getById(id);
        return Response.success(UserAppConverter.INSTANCE.to(aggregate));
    }

    @Override
    public Response<GetUserResponse> getByUserName(String userName) {
        UserAggregate aggregate = userPersistence.getByUserName(userName);
        return Response.success(UserAppConverter.INSTANCE.to(aggregate));
    }

    @Override
    public Response<GetUserResponse> getByMobilePhone(String mobilePhone) {
        UserAggregate aggregate = userPersistence.getByMobilePhone(mobilePhone);
        return Response.success(UserAppConverter.INSTANCE.to(aggregate));
    }

    @Override
    public Response<ListUserResponse> listUsers() {
        List<UserAggregate> list = userPersistence.listUsers();
        return Response.success(UserAppConverter.INSTANCE.to(list));
    }

    @Override
    public Response<LoadUserResponse> loadUserByUsername(String userName) {
        UserAggregate aggregate = userPersistence.loadUserByUsername(userName);
        return Response.success(UserAppConverter.INSTANCE.load(aggregate));
    }
}
