package com.faircloud.iam.user.application.service;

import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.ListUserResponse;
import com.faircloud.iam.user.client.module.LoadUserResponse;
import com.faircloud.platform.common.application.ApplicationQryService;
import com.faircloud.platform.common.module.Response;

public interface UserAppQryService extends ApplicationQryService {

    /**
     * 根据主键查询用户信息
     *
     * @param id 主键
     * @return 用户
     */
    Response<GetUserResponse> getById(Long id);

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户
     */
    Response<GetUserResponse> getByUserName(String userName);

    /**
     * 根据手机号码查询用户信息
     *
     * @param mobilePhone 手机号码
     * @return 用户
     */
    Response<GetUserResponse> getByMobilePhone(String mobilePhone);

    /**
     * 列出用户信息
     * @return 用户数据
     */
    Response<ListUserResponse> listUsers();

    /**
     * 登录用，根据用户名获取用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    Response<LoadUserResponse> loadUserByUsername(String userName);
}
