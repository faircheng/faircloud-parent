package com.faircloud.iam.password.client.fallback;

import com.faircloud.iam.password.client.api.PasswordPolicyClient;
import com.faircloud.iam.password.client.module.SetPasswordPolicyRequest;
import com.faircloud.iam.user.client.api.AccessKeyClient;
import com.faircloud.iam.user.client.module.CreateAccessKeyRequest;
import com.faircloud.iam.user.client.module.DeleteAccessKeyRequest;
import com.faircloud.iam.user.client.module.GetAccessKeyRequest;
import com.faircloud.iam.user.client.module.UpdateAccessKeyRequest;
import com.faircloud.platform.common.module.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 触发服务降级时会调用相应的方法
 *
 * @author Fair Cheng
 */
@Slf4j
@Component
public class PasswordPolicyClientFallback implements FallbackFactory<PasswordPolicyClient> {

    @Override
    public PasswordPolicyClient create(Throwable cause) {
        log.info("client fallback error");
        return new PasswordPolicyClient() {

            @Override
            public Response setPasswordPolicy(SetPasswordPolicyRequest request) {
                return null;
            }

            @Override
            public Response getPasswordPolicy() {
                return null;
            }
        };
    }
}
