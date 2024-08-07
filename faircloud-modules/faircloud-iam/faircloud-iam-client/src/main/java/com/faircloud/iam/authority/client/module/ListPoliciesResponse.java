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
 * 查询用户组信息 返回参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "查询用户组信息 返回参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListPoliciesResponse extends DTO {

    @Schema(description = "主键")
    private String id;

    @Schema(name = "权限策略类型")
    private String policyType;

    @Schema(name = "权限策略名称")
    private String policyName;

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
