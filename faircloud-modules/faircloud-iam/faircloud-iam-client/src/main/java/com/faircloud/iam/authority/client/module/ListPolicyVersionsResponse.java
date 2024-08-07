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
 * 列出权限策略版本 返回参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "列出权限策略版本 返回参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListPolicyVersionsResponse extends DTO {

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
