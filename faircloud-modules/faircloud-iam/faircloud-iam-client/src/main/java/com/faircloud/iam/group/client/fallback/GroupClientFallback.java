package com.faircloud.iam.group.client.fallback;

import com.faircloud.iam.group.client.GroupClient;
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
public class GroupClientFallback implements FallbackFactory<GroupClient> {

    @Override
    public GroupClient create(Throwable cause) {
        log.info("client fallback error");
        return new GroupClient() {

        };
    }
}
