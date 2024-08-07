package com.faircloud.iam.user.client.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.faircloud.iam.user.client.api.LoginProfileClient;
import com.faircloud.iam.user.client.module.ChangePasswordRequest;
import com.faircloud.iam.user.client.module.CreateLoginProfileRequest;
import com.faircloud.iam.user.client.module.DeleteLoginProfileRequest;
import com.faircloud.iam.user.client.module.GetLoginProfileRequest;
import com.faircloud.iam.user.client.module.UpdateLoginProfileRequest;
import com.faircloud.platform.common.module.Response;

import lombok.extern.slf4j.Slf4j;

/**
 * 触发服务降级时会调用相应的方法
 * @author Felix Cheng
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
            public Response getLoginProfile(GetLoginProfileRequest request) {
                return null;
            }

            @Override
            public Response updateLoginProfile(UpdateLoginProfileRequest request) {
                return null;
            }

            @Override
            public Response deleteLoginProfile(DeleteLoginProfileRequest request) {
                return null;
            }

            @Override
            public Response changePassword(ChangePasswordRequest request) {
                return null;
            }
        };
    }
}
