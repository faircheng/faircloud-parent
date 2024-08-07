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
 * 列出用户组的权限策略 返回参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "列出用户组的权限策略 返回参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListPoliciesForGroupResponse extends DTO {

    @Schema(name = "默认版本")
    private String defaultVersion;

    @Schema(name = "权限策略描述")
    private String description;

    @Schema(name = "权限策略名称")
    private String policyName;

    @Schema(name = "权限策略类型")
    private String policyType;

    @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
    @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
    @Schema(name = "授权时间")
    private Date attachDate;
}
