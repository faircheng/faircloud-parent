package com.faircloud.iam.group.client.module;

import com.faircloud.platform.common.module.Query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 列出指定RAM用户所加入的用户组信息 请求参数
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "列出指定RAM用户所加入的用户组信息 请求参数")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListGroupsForUserRequest extends Query {

    @Schema(name = "IAM 用户名称")
    private String userName;
}
