package com.faircloud.iam.group.client.module;

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
public class GetGroupResponse extends DTO {

    @Schema(description = "主键")
    private String id;

    @Schema(description = "用户组名称")
    private String groupName;

    @Schema(description = "用户组显示名称")
    private String displayName;

    @Schema(description = "备注信息")
    private String comments;

    @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
    @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
    @Schema(name = "创建时间")
    private Date createTime;

    @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
    @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
    @Schema(name = "更新时间")
    private Date updateTime;
}
