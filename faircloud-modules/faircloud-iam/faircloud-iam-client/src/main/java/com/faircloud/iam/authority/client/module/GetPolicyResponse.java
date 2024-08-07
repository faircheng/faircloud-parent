package com.faircloud.iam.authority.client.module;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.faircloud.platform.common.contants.PlatformConstants;
import com.faircloud.platform.common.module.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 获取指定的权限策略信息 返回参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "获取指定的权限策略信息 返回参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetPolicyResponse extends DTO {

    @Schema(name = "权限策略的基本信息")
    private GetPolicyResponseBodyPolicy policy;

    @Schema(name = "权限策略的默认版本")
    private GetPolicyResponseBodyDefaultPolicyVersion defaultPolicyVersion;

    /**
     * 权限策略的基本信息 返回参数
     *
     * @author Felix Cheng
     */
    @Data
    @Builder
    @Schema(description = "权限策略的基本信息 返回参数")
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetPolicyResponseBodyPolicy extends DTO {

        @Schema(name = "权限策略类型")
        private String policyType;

        @Schema(name = "权限策略名称")
        private String policyName;

        @Schema(name = "权限策略内容")
        private String policyDocument;

        @Schema(name = "引用次数")
        private Integer attachmentCount;

        @Schema(name = "权限策略描述")
        private String description;

        @Schema(name = "默认版本")
        private String defaultVersion;

        @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
        @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
        @Schema(name = "创建时间")
        private Date createTime;

        @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
        @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
        @Schema(name = "更新时间")
        private Date updateTime;
    }

    /**
     * 权限策略的默认版本 返回参数
     *
     * @author Felix Cheng
     */
    @Data
    @Builder
    @Schema(description = "权限策略的默认版本 返回参数")
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetPolicyResponseBodyDefaultPolicyVersion extends DTO {

        @Schema(name = "是否默认版本")
        private Boolean isDefaultVersion;

        @Schema(name = "权限策略内容")
        private String policyDocument;

        @Schema(name = "权限策略版本")
        private String versionId;

        @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
        @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
        @Schema(name = "创建时间")
        private Date createTime;
    }
}
