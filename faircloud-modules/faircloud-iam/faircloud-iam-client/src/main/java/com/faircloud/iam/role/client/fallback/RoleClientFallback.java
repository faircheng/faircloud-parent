package com.faircloud.iam.role.client.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.faircloud.iam.role.client.api.RoleClient;

import lombok.extern.slf4j.Slf4j;

/**
 * 触发服务降级时会调用相应的方法
 *
 * @author Felix Cheng
 */
@Slf4j
@Component
public class RoleClientFallback implements FallbackFactory<RoleClient> {

    @Override
    public RoleClient create(Throwable cause) {
        log.info("client fallback error");
        return null;
    }
}
