package com.faircloud.iam.role.client.module;

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
 * 获取角色列表 返回参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "获取角色列表 返回参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListRolesResponse extends DTO {

    @Schema(description = "主键")
    private String id;

    @Schema(name = "IAM 角色名称。长度为 1~64 个字符，可包含英文字母、数字、英文句点（.）、下划线（_）和短划线（-）")
    private String roleName;

    @Schema(name = "显示名称")
    private String displayName;

    @Schema(name = "角色描述。长度为 1~1024 个字符。")
    private String description;

    @Schema(name = "信任策略。指定允许扮演该 IAM 角色的一个或多个主体，这个主体可以是账号、服务或身份提供商。")
    private String assumeRolePolicyDocument;

    @Schema(name = "IAM 角色最大会话时间。取值范围：3600 秒~43200 秒。默认值：3600 秒。取值为空时将采用默认值。")
    private Long maxSessionDuration;

    @Schema(name = "角色的资源描述符")
    private String arn;

    @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
    @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
    @Schema(name = "创建时间")
    private Date createTime;

    @JsonFormat(pattern = PlatformConstants.TIME_FORMAT, timezone = PlatformConstants.TIMEZONE)
    @DateTimeFormat(pattern = PlatformConstants.TIME_FORMAT)
    @Schema(name = "更新时间")
    private Date updateTime;
}
