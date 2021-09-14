package com.faircloud.platform.upms.user.client;

import com.faircloud.platform.common.dto.ResponseDTO;
import com.faircloud.platform.upms.user.dto.UserAddDTO;
import com.faircloud.platform.upms.user.vo.UserVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 用户接口
 * @author Fair Cheng
 */
@Api(tags="用户操作接口")
@ApiSort(value = 1)
public interface UserClient {

    @ApiOperation(value = "查询用户信息",response = UserVO.class)
    @ApiOperationSupport(order=1)
    @ApiImplicitParam(name = "userCode",value = "用户编码")
    @GetMapping("/user/{userCode}")
    ResponseDTO<UserVO> getUserByUserCode(@PathVariable("userCode") String userCode);

    @ApiOperation(value="用户新增接口")
    @ApiOperationSupport(order=2)
    @PostMapping("/user")
    ResponseDTO insert(@ApiParam(value = "新增用户参数") @Valid @RequestBody UserAddDTO dto);
}
