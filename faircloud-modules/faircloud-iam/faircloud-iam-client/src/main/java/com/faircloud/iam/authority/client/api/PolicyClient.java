package com.faircloud.iam.authority.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.faircloud.iam.IamService;
import com.faircloud.iam.authority.client.fallback.PolicyClientFallback;
import com.faircloud.iam.authority.client.module.CreatePolicyRequest;
import com.faircloud.iam.authority.client.module.CreatePolicyVersionRequest;
import com.faircloud.iam.authority.client.module.DeletePolicyRequest;
import com.faircloud.iam.authority.client.module.DeletePolicyVersionRequest;
import com.faircloud.iam.authority.client.module.GetPolicyRequest;
import com.faircloud.iam.authority.client.module.GetPolicyResponse;
import com.faircloud.iam.authority.client.module.GetPolicyVersionRequest;
import com.faircloud.iam.authority.client.module.GetPolicyVersionResponse;
import com.faircloud.iam.authority.client.module.ListPoliciesRequest;
import com.faircloud.iam.authority.client.module.ListPoliciesResponse;
import com.faircloud.iam.authority.client.module.ListPolicyVersionsRequest;
import com.faircloud.iam.authority.client.module.ListPolicyVersionsResponse;
import com.faircloud.iam.authority.client.module.SetDefaultPolicyVersionRequest;
import com.faircloud.iam.authority.client.module.UpdatePolicyDescriptionRequest;
import com.faircloud.platform.common.module.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 权限策略管理 接口
 *
 * @author Felix Cheng
 */
@Tag(name = "权限策略管理 接口")
@ApiSort(value = IamService.POLICY)
@FeignClient(name = IamService.NAME, fallbackFactory = PolicyClientFallback.class)
public interface PolicyClient {

    @Operation(summary = "创建一个权限策略")
    @ApiOperationSupport(order = 1)
    @PostMapping("/policies")
    Response<Void> createPolicy(@Valid @RequestBody CreatePolicyRequest request);

    @Operation(summary = "获取指定的权限策略信息")
    @ApiOperationSupport(order = 2)
    @GetMapping("/policies")
    Response<GetPolicyResponse> getPolicy(@Valid @RequestBody GetPolicyRequest request);

    @Operation(summary = "更新自定义策略的描述信息")
    @ApiOperationSupport(order = 3)
    @PutMapping("/policies-description")
    Response<Void> updatePolicyDescription(@Valid @RequestBody UpdatePolicyDescriptionRequest request);

    @Operation(summary = "删除指定的权限策略")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/policies")
    Response<Void> deletePolicy(@Valid @RequestBody DeletePolicyRequest request);

    @Operation(summary = "列出权限策略")
    @ApiOperationSupport(order = 5)
    @GetMapping("/policies")
    Response<ListPoliciesResponse> listPolicies(@Valid @RequestBody ListPoliciesRequest request);

    @Operation(summary = "为权限策略创建新的版本")
    @ApiOperationSupport(order = 6)
    @PostMapping("/policies-version")
    Response<Void> createPolicyVersion(@Valid @RequestBody CreatePolicyVersionRequest request);

    @Operation(summary = "获取某个权限策略的版本")
    @ApiOperationSupport(order = 7)
    @GetMapping("/policy-version")
    Response<GetPolicyVersionResponse> getPolicyVersion(@Valid @RequestBody GetPolicyVersionRequest request);

    @Operation(summary = "删除指定的权限策略的某个版本")
    @ApiOperationSupport(order = 8)
    @DeleteMapping("/policy-version")
    Response<Void> deletePolicyVersion(@Valid @RequestBody DeletePolicyVersionRequest request);

    @Operation(summary = "列出权限策略版本")
    @ApiOperationSupport(order = 9)
    @GetMapping("/policy-version")
    Response<ListPolicyVersionsResponse> listPolicyVersions(@Valid @RequestBody ListPolicyVersionsRequest request);

    @Operation(summary = "设置权限策略默认版本")
    @ApiOperationSupport(order = 10)
    @PutMapping("/set-default-policy-version")
    Response<Void> setDefaultPolicyVersion(@Valid @RequestBody SetDefaultPolicyVersionRequest request);
}
