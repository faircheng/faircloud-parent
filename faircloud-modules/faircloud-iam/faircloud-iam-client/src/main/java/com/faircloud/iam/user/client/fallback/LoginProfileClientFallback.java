package com.faircloud.iam.user.client.fallback;

import com.faircloud.iam.user.client.api.LoginProfileClient;
import com.faircloud.iam.user.client.api.UserClient;
import com.faircloud.iam.user.client.module.*;
import com.faircloud.platform.common.module.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 触发服务降级时会调用相应的方法
 * @author Fair Cheng
 */
@Slf4j
@Component
public class LoginProfileClientFallback implements FallbackFactory<LoginProfileClient> {

    @Override
    public LoginProfileClient create(Throwable cause) {
        log.info("client fallback error");
        return new LoginProfileClient() {

            @Override
            public Response createLoginProfile(CreateLoginProfileRequest request) {
                return null;
            }

            @Override
            public Response getLoginProfile(String userName) {
                return null;
            }

            @Override
            public Response updateLoginProfile(UpdateLoginProfileRequest request) {
                return null;
            }

            @Override
            public Response deleteLoginProfile(String userName) {
                return null;
            }

            @Override
            public Response changePassword(ChangePasswordRequest request) {
                return null;
            }
        };
    }
}
