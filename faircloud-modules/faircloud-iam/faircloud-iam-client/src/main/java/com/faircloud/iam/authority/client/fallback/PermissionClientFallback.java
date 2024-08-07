package com.faircloud.iam.authority.client.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.faircloud.iam.authority.client.api.PermissionClient;

import lombok.extern.slf4j.Slf4j;

/**
 * 触发服务降级时会调用相应的方法
 *
 * @author Felix Cheng
 */
@Slf4j
@Component
public class PermissionClientFallback implements FallbackFactory<PermissionClient> {

    @Override
    public PermissionClient create(Throwable cause) {
        log.info("client fallback error");
        return null;
    }
}
