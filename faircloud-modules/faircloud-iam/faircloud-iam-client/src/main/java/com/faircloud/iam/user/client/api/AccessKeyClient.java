package com.faircloud.iam.user.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.user.client.fallback.AccessKeyClientFallback;
import com.faircloud.iam.user.client.module.CreateAccessKeyRequest;
import com.faircloud.iam.user.client.module.DeleteAccessKeyRequest;
import com.faircloud.iam.user.client.module.GetAccessKeyRequest;
import com.faircloud.iam.user.client.module.UpdateAccessKeyRequest;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 访问密钥接口
 *
 * @author Fair Cheng
 */
@Tag(name = "访问密钥接口")
@ApiSort(value = 4)
@FeignClient(name = "faircloud-iam-service", fallbackFactory = AccessKeyClientFallback.class)
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
