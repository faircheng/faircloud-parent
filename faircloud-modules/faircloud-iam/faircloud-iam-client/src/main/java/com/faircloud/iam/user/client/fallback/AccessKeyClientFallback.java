package com.faircloud.iam.user.client.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.faircloud.iam.user.client.api.AccessKeyClient;
import com.faircloud.iam.user.client.module.CreateAccessKeyRequest;
import com.faircloud.iam.user.client.module.DeleteAccessKeyRequest;
import com.faircloud.iam.user.client.module.GetAccessKeyLastUsedRequest;
import com.faircloud.iam.user.client.module.GetAccessKeyLastUsedResponse;
import com.faircloud.iam.user.client.module.GetAccessKeyRequest;
import com.faircloud.iam.user.client.module.UpdateAccessKeyRequest;
import com.faircloud.platform.common.module.Response;

import lombok.extern.slf4j.Slf4j;

/**
 * 触发服务降级时会调用相应的方法
 *
 * @author Felix Cheng
 */
@Slf4j
@Component
public class AccessKeyClientFallback implements FallbackFactory<AccessKeyClient> {

    @Override
    public AccessKeyClient create(Throwable cause) {
        log.info("client fallback error");
        return new AccessKeyClient() {

            @Override
            public Response createAccessKey(CreateAccessKeyRequest request) {
                return null;
            }

            @Override
            public Response updateAccessKey(UpdateAccessKeyRequest request) {
                return null;
            }

            @Override
            public Response deleteAccessKey(DeleteAccessKeyRequest request) {
                return null;
            }

            @Override
            public Response listAccessKeys(GetAccessKeyRequest request) {
                return null;
            }

            @Override
            public Response<GetAccessKeyLastUsedResponse> getAccessKeyLastUsed(GetAccessKeyLastUsedRequest request) {
                return null;
            }
        };
    }
}
