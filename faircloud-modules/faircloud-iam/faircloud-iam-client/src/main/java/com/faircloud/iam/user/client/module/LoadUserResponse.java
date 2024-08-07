package com.faircloud.iam.user.client.module;

import com.faircloud.platform.common.module.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * loadUserByUsername 返回
 *
 * @author Felix Cheng
 */
@Data
@Builder
@Schema(description = "loadUserByUsername 返回")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class LoadUserResponse extends DTO {

    @Schema(description = "主键")
    private Long id;

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

    @Schema(description = "用户过期")
    private Boolean accountNonExpired;

    @Schema(description = "用户锁定")
    private Boolean accountNonLocked;

    @Schema(description = "密码过期")
    private Boolean credentialsNonExpired;

    @Schema(description = "控制台访问：开启或禁用")
    private Boolean enabled;

    @Schema(description = "账号的描述信息")
    private String description;

    @Schema(description = "密码")
    private String password;
}
