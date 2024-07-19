package com.faircloud.iam.group.client;

import com.faircloud.iam.user.client.fallback.UserClientFallback;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户组管理接口
 *
 * @author Fair Cheng
 */
@Tag(name="用户组管理接口")
@ApiSort(value = 2)
@FeignClient(name = "faircloud-iam-group-service",fallbackFactory= UserClientFallback.class)
public interface GroupClient {

}
