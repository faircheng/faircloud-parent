package com.faircloud.iam.user.client.module;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 列出用户信息参数
 * @author Fair Cheng
 */
@Data
@Schema(description = "列出用户信息参数")
public class ListUserResponse {

    @Schema(description = "主键")
    private String id;

    @Schema(description = "用户名")
    private String userName;

    @Schema(description = "主账号ID")
    private String parentId;

    @Schema(description = "手机号")
    private String mobilePhone;

    @Schema(description = "手机号是否通过验证")
    private Boolean mobilePhoneIsVerify;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "电子邮箱是否通过验证")
    private Boolean emailIsVerify;

    @Schema(description = "账户是否可用")
    private Boolean enabled;

    @Schema(description = "账号的描述信息")
    private String description;
}
