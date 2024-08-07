package com.faircloud.iam.user.client.api;

import org.springframework.cloud.openfeign.FeignClient;

import com.faircloud.iam.IamService;
import com.faircloud.iam.user.client.fallback.VirtualMFADeviceClientFallback;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 多因素认证 接口
 *
 * @author Felix Cheng
 */
@Tag(name = "多因素认证 接口")
@ApiSort(value = IamService.MFA)
@FeignClient(name = IamService.NAME, fallbackFactory = VirtualMFADeviceClientFallback.class)
public interface VirtualMFADeviceClient {

}
