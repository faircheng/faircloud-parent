package com.faircloud.platform.upms.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 新增用户
 * @author Fair Cheng
 */
@Data
@ApiModel(value = "新增用户")
public class UserAddDTO {

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String userName;
}
