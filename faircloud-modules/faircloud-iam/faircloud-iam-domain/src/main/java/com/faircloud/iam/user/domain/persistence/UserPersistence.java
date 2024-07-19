package com.faircloud.iam.user.domain.persistence;

import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.valueobject.MobilePhone;
import com.faircloud.platform.common.persistence.Persistence;

import java.util.List;

/**
 * user 持久化接口
 *
 * @author Fair Cheng
 */
public interface UserPersistence extends Persistence {

    /**
     * 注册账号
     *
     * @param aggregate 用户信息
     */
    void save(UserAggregate aggregate);

    UserAggregate getById(Long id);

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户
     */
    UserAggregate getByUserName(String userName);

    /**
     * 根据手机号码查询用户信息
     *
     * @param mobilePhone 手机号码
     * @return 用户
     */
    UserAggregate getByMobilePhone(String mobilePhone);

    /**
     * loadUserByUsername
     *
     * @param username 账号
     * @return 用户
     */
    UserAggregate loadUserByUsername(String username);

    /**
     * 列出用户
     *
     * @return 用户
     */
    List<UserAggregate> listUsers();

    /**
     * 用户名校验
     *
     * @param userName 用户名
     * @param id       主键
     * @return Boolean
     */
    Boolean checkUserName(String userName, Long id);

    /**
     * 手机号校验
     *
     * @param mobilePhone 手机号
     * @param id          主键
     * @return Boolean
     */
    Boolean checkMobilePhone(MobilePhone mobilePhone, Long id);
}
