package com.faircloud.iam.user.client.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.faircloud.iam.user.client.api.AccountClient;
import com.faircloud.iam.user.client.module.DeleteAccountRequest;
import com.faircloud.iam.user.client.module.GetUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.RegisterAccountRequest;
import com.faircloud.iam.user.client.module.RegisterMobileRequest;
import com.faircloud.platform.common.module.Response;

import lombok.extern.slf4j.Slf4j;

/**
 * 触发服务降级时会调用相应的方法
 * @author Felix Cheng
 */
@Slf4j
@Component
public class AccountClientFallback implements FallbackFactory<AccountClient> {

    @Override
    public AccountClient create(Throwable cause) {
        log.info("client fallback error");
        return new AccountClient() {

            @Override
            public Response mobileReg(RegisterMobileRequest request) {
                return null;
            }

            @Override
            public Response register(RegisterAccountRequest request) {
                return null;
            }

            @Override
            public Response<GetUserResponse> getAccount(GetUserRequest request) {
                return null;
            }

            @Override
            public Response<Void> cancellation(DeleteAccountRequest request) {
                return null;
            }
        };
    }
}
