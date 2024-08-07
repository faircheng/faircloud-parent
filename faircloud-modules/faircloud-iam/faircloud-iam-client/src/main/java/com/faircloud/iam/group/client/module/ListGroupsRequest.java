package com.faircloud.iam.group.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 查询用户组列表 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "查询用户组列表 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListGroupsRequest extends Query {

    @Schema(name = "用户名")
    private String userName;
}
