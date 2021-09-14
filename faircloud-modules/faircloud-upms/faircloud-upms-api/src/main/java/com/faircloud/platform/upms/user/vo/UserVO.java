package com.faircloud.platform.upms.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户信息
 * @author Fair Cheng
 */
@Data
@ApiModel(value = "用户信息")
public class UserVO {

    @ApiModelProperty(value = "用户名")
    private String userName;
}
