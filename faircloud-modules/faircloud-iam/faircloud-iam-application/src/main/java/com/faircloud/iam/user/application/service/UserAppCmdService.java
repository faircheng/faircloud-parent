package com.faircloud.iam.user.application.service;

import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.RegisterAccountRequest;
import com.faircloud.iam.user.client.module.RegisterMobileRequest;
import com.faircloud.platform.common.application.ApplicationCmdService;
import com.faircloud.platform.common.module.Response;

/**
 * user application command service
 *
 * @author Fair Cheng
 */
public interface UserAppCmdService extends ApplicationCmdService {

    /**
     * 账号密码注册
     *
     * @param request 账号密码注册
     * @return Response
     */
    Response register(RegisterAccountRequest request);

    /**
     * 手机号注册
     *
     * @param request 手机号注册
     * @return Response
     */
    Response mobileReg(RegisterMobileRequest request);

    /**
     * 创建用户
     * @param request 用户信息
     * @return Response
     */
    Response createUser(CreateUserRequest request);

    /**
     * 更新用户
     * @param request 用户信息
     * @return Response
     */
    Response updateUser(CreateUserRequest request);

    /**
     * 删除用户信息
     * @param userName 用户名
     * @return Response
     */
    Response deleteUser(String userName);
}
