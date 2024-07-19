package com.faircloud.iam.user.client.api;

import com.faircloud.iam.user.client.fallback.AccessKeyClientFallback;
import com.faircloud.iam.user.client.module.*;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 访问密钥接口
 *
 * @author Fair Cheng
 */
@Tag(name = "访问密钥接口")
@ApiSort(value = 4)
@FeignClient(name = "faircloud-iam-access-key-service", fallbackFactory = AccessKeyClientFallback.class)
public interface AccessKeyClient {

    @Operation(summary = "创建访问密钥")
    @ApiOperationSupport(order = 1)
    @PostMapping("/access-keys")
    Response createAccessKey(@Valid @RequestBody CreateAccessKeyRequest request);

    @Operation(summary = "更新访问密钥的状态")
    @ApiOperationSupport(order = 2)
    @PutMapping("/access-keys")
    Response updateAccessKey(@Valid @RequestBody UpdateAccessKeyRequest request);

    @Operation(summary = "删除访问密钥")
    @ApiOperationSupport(order = 3)
    @DeleteMapping("/access-keys")
    Response deleteAccessKey(@Valid @RequestBody DeleteAccessKeyRequest request);

    @Operation(summary = "列出指定用户的访问密钥")
    @ApiOperationSupport(order = 4)
    @GetMapping("/access-keys")
    Response listAccessKeys(@Valid GetAccessKeyRequest request);
}
