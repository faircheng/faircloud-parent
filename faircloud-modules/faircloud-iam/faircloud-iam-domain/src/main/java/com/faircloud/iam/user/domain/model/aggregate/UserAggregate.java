package com.faircloud.iam.user.domain.model.aggregate;

import com.faircloud.iam.user.domain.model.entity.LoginProfileEntity;
import com.faircloud.iam.user.domain.model.entity.UserInfoEntity;
import com.faircloud.iam.user.domain.model.valueobject.Email;
import com.faircloud.iam.user.domain.model.valueobject.MobilePhone;
import com.faircloud.platform.common.contants.PlatformConstants;
import com.faircloud.platform.common.model.Aggregate;
import com.faircloud.platform.common.model.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

/**
 * 用户 聚合根
 *
 * @author Fair Cheng
 */
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserAggregate implements Aggregate, Entity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 主账号ID:主账号为0
     */
    private UserAggregate parentId;

    /**
     * 账号名
     */
    private String userName;

    /**
     * 安全手机号码
     */
    private MobilePhone mobilePhone;

    /**
     * 手机号是否通过验证
     */
    private Boolean mobilePhoneIsVerify;

    /**
     * 安全电子邮箱
     */
    private Email email;

    /**
     * 电子邮箱是否通过验证
     */
    private Boolean emailIsVerify;

    /**
     * 注销账号，true为启用，false为停用，默认为true。
     */
    private Boolean enabled;

    /**
     * 账号的描述信息
     */
    private String description;

    /**
     * 是否删除
     */
    private Boolean deleted;

    private UserInfoEntity userInfo;

    private LoginProfileEntity loginProfile;

    public UserAggregate(Long id) {
        this.id = id;
    }

    public void mobileReg(MobilePhone mobilePhone, LoginProfileEntity loginProfile, UserInfoEntity userInfo) {
        this.parentId = new UserAggregate(0L);
        this.userName = PlatformConstants.DEFAULT_USER_NAME + this.id;
        this.mobilePhone = mobilePhone;
        this.mobilePhoneIsVerify = Boolean.TRUE;
        this.loginProfile = loginProfile;
        this.userInfo = userInfo;
    }

    public void register(String userName, MobilePhone mobilePhone, LoginProfileEntity loginProfile, UserInfoEntity userInfo) {
        this.parentId = new UserAggregate(0L);
        this.userName = userName;
        this.mobilePhone = mobilePhone;
        this.mobilePhoneIsVerify = Boolean.TRUE;
        this.loginProfile = loginProfile;
        this.userInfo = userInfo;
    }

    public void createUser(UserAggregate parentId, String userName, LoginProfileEntity loginProfile, UserInfoEntity userInfo) {
        this.parentId = parentId;
        this.userName = userName;
        this.loginProfile = loginProfile;
        this.userInfo = userInfo;
    }
}
