package com.faircloud.iam.user.client.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.faircloud.iam.user.client.api.UserClient;
import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.ListUserResponse;
import com.faircloud.iam.user.client.module.LoadUserResponse;
import com.faircloud.platform.common.module.Response;

import lombok.extern.slf4j.Slf4j;

/**
 * 触发服务降级时会调用相应的方法
 * @author Fair Cheng
 */
@Slf4j
@Component
public class UserClientFallback implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable cause) {
        log.info("client fallback error");
        return new UserClient() {

            @Override
            public Response<GetUserResponse> getByUserName(String userName) {
                return null;
            }

            @Override
            public Response createUser(CreateUserRequest request) {
                return null;
            }

            @Override
            public Response updateUser(CreateUserRequest request) {
                return null;
            }

            @Override
            public Response<Void> deleteUser(String userName) {
                return null;
            }

            @Override
            public Response<ListUserResponse> listUsers() {
                return null;
            }

            @Override
            public Response<LoadUserResponse> loadUserByUsername(String userName) {
                return null;
            }
        };
    }
}
