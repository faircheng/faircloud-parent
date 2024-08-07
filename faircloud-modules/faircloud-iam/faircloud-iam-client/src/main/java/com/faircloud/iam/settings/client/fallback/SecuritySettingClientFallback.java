package com.faircloud.iam.settings.client.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.faircloud.iam.settings.client.api.SecuritySettingClient;

import lombok.extern.slf4j.Slf4j;

/**
 * 触发服务降级时会调用相应的方法
 *
 * @author Felix Cheng
 */
@Slf4j
@Component
public class SecuritySettingClientFallback implements FallbackFactory<SecuritySettingClient> {

    @Override
    public SecuritySettingClient create(Throwable cause) {
        log.info("client fallback error");
        return null;
    }
}
