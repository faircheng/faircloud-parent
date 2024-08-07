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
 * 列出引用权限策略的实体 返回参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "列出引用权限策略的实体 返回参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListEntitiesForPolicyResponse extends DTO {

    @Schema(name = "用户组信息")
    private ListEntitiesForPolicyResponseBodyGroups groups;

    @Schema(name = "角色信息")
    private ListEntitiesForPolicyResponseBodyRoles roles;

    @Schema(name = "用户信息")
    private ListEntitiesForPolicyResponseBodyUsers users;

    @Data
    @Builder
    @Schema(description = "列出引用权限策略的实体 用户组信息")
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListEntitiesForPolicyResponseBodyGroups extends DTO {

        @Schema(name = "组名称")
        private String groupName;

        @Schema(name = "备注信息")
        private String comments;

        @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
        @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
        @Schema(name = "授权时间")
        private Date attachDate;
    }

    @Data
    @Builder
    @Schema(description = "列出引用权限策略的实体 角色信息")
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListEntitiesForPolicyResponseBodyRoles extends DTO {

        @Schema(name = "角色的文字描述")
        private String description;

        @Schema(name = "角色名称")
        private String roleName;

        @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
        @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
        @Schema(name = "授权时间")
        private Date attachDate;

        @Schema(name = "角色的资源描述符")
        private String arn;

        @Schema(name = "角色 ID")
        private String roleId;
    }

    @Data
    @Builder
    @Schema(description = "列出引用权限策略的实体 用户信息")
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListEntitiesForPolicyResponseBodyUsers extends DTO {

        @Schema(name = "显示名称")
        private String displayName;

        @Schema(name = "用户唯一标识")
        private String userId;

        @Schema(name = "用户名称")
        private String userName;

        @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
        @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
        @Schema(name = "授权时间")
        private Date attachDate;
    }
}
