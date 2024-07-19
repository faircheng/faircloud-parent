package com.faircloud.iam.user.infrastructure.persistence.converter;

import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.entity.LoginProfileEntity;
import com.faircloud.iam.user.domain.model.entity.UserInfoEntity;
import com.faircloud.iam.user.domain.model.valueobject.Email;
import com.faircloud.iam.user.domain.model.valueobject.MobilePhone;
import com.faircloud.iam.user.infrastructure.persistence.po.LoginProfile;
import com.faircloud.iam.user.infrastructure.persistence.po.User;
import com.faircloud.iam.user.infrastructure.persistence.po.UserInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T16:49:36+0800",
    comments = "version: 1.6.0.Beta2, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class UserInfraConverterImpl implements UserInfraConverter {

    @Override
    public User to(UserAggregate aggregate) {
        if ( aggregate == null ) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.parentId( aggregateParentIdId( aggregate ) );
        user.mobilePhone( aggregateMobilePhoneMobilePhone( aggregate ) );
        user.email( aggregateEmailEmail( aggregate ) );
        user.id( aggregate.getId() );
        user.userName( aggregate.getUserName() );
        user.mobilePhoneIsVerify( aggregate.getMobilePhoneIsVerify() );
        user.emailIsVerify( aggregate.getEmailIsVerify() );
        user.enabled( aggregate.getEnabled() );
        user.description( aggregate.getDescription() );
        user.deleted( aggregate.getDeleted() );

        return user.build();
    }

    @Override
    public UserAggregate to(User user) {
        if ( user == null ) {
            return null;
        }

        UserAggregate.UserAggregateBuilder<?, ?> userAggregate = UserAggregate.builder();

        userAggregate.parentId( userToUserAggregate( user ) );
        userAggregate.mobilePhone( userToMobilePhone( user ) );
        userAggregate.email( userToEmail( user ) );
        userAggregate.id( user.getId() );
        userAggregate.userName( user.getUserName() );
        userAggregate.mobilePhoneIsVerify( user.getMobilePhoneIsVerify() );
        userAggregate.emailIsVerify( user.getEmailIsVerify() );
        userAggregate.enabled( user.getEnabled() );
        userAggregate.description( user.getDescription() );
        userAggregate.deleted( user.getDeleted() );

        return userAggregate.build();
    }

    @Override
    public UserAggregate to(User user, LoginProfile loginProfile, UserInfo userInfo) {
        if ( user == null && loginProfile == null && userInfo == null ) {
            return null;
        }

        UserAggregate.UserAggregateBuilder<?, ?> userAggregate = UserAggregate.builder();

        if ( user != null ) {
            userAggregate.parentId( userToUserAggregate1( user ) );
            userAggregate.mobilePhone( userToMobilePhone1( user ) );
            userAggregate.email( userToEmail1( user ) );
            userAggregate.id( user.getId() );
            userAggregate.enabled( user.getEnabled() );
            userAggregate.userName( user.getUserName() );
            userAggregate.mobilePhoneIsVerify( user.getMobilePhoneIsVerify() );
            userAggregate.emailIsVerify( user.getEmailIsVerify() );
            userAggregate.description( user.getDescription() );
            userAggregate.deleted( user.getDeleted() );
        }
        userAggregate.loginProfile( to( loginProfile ) );
        userAggregate.userInfo( to( userInfo ) );

        return userAggregate.build();
    }

    @Override
    public List<UserAggregate> to(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserAggregate> list = new ArrayList<UserAggregate>( userList.size() );
        for ( User user : userList ) {
            list.add( to( user ) );
        }

        return list;
    }

    @Override
    public LoginProfile to(LoginProfileEntity loginProfile) {
        if ( loginProfile == null ) {
            return null;
        }

        LoginProfile.LoginProfileBuilder<?, ?> loginProfile1 = LoginProfile.builder();

        loginProfile1.userId( loginProfileUserIdId( loginProfile ) );
        loginProfile1.id( loginProfile.getId() );
        loginProfile1.password( loginProfile.getPassword() );
        loginProfile1.passwordResetRequired( loginProfile.getPasswordResetRequired() );
        loginProfile1.lastLoginDate( loginProfile.getLastLoginDate() );
        loginProfile1.lastLoginIp( loginProfile.getLastLoginIp() );
        loginProfile1.accountNonExpired( loginProfile.getAccountNonExpired() );
        loginProfile1.accountNonLocked( loginProfile.getAccountNonLocked() );
        loginProfile1.credentialsNonExpired( loginProfile.getCredentialsNonExpired() );
        loginProfile1.enabled( loginProfile.getEnabled() );

        return loginProfile1.build();
    }

    @Override
    public LoginProfileEntity to(LoginProfile loginProfile) {
        if ( loginProfile == null ) {
            return null;
        }

        LoginProfileEntity.LoginProfileEntityBuilder<?, ?> loginProfileEntity = LoginProfileEntity.builder();

        loginProfileEntity.userId( loginProfileToUserAggregate( loginProfile ) );
        loginProfileEntity.id( loginProfile.getId() );
        loginProfileEntity.password( loginProfile.getPassword() );
        loginProfileEntity.passwordResetRequired( loginProfile.getPasswordResetRequired() );
        loginProfileEntity.lastLoginDate( loginProfile.getLastLoginDate() );
        loginProfileEntity.lastLoginIp( loginProfile.getLastLoginIp() );
        loginProfileEntity.enabled( loginProfile.getEnabled() );
        loginProfileEntity.accountNonExpired( loginProfile.getAccountNonExpired() );
        loginProfileEntity.accountNonLocked( loginProfile.getAccountNonLocked() );
        loginProfileEntity.credentialsNonExpired( loginProfile.getCredentialsNonExpired() );

        return loginProfileEntity.build();
    }

    @Override
    public UserInfo to(UserInfoEntity userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        UserInfo.UserInfoBuilder<?, ?> userInfo1 = UserInfo.builder();

        userInfo1.userId( userInfoUserIdId( userInfo ) );
        userInfo1.mobilePhone( userInfoMobilePhoneMobilePhone( userInfo ) );
        userInfo1.email( userInfoEmailEmail( userInfo ) );
        userInfo1.id( userInfo.getId() );
        userInfo1.displayName( userInfo.getDisplayName() );
        userInfo1.sex( userInfo.getSex() );
        userInfo1.comments( userInfo.getComments() );

        return userInfo1.build();
    }

    @Override
    public UserInfoEntity to(UserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        UserInfoEntity.UserInfoEntityBuilder<?, ?> userInfoEntity = UserInfoEntity.builder();

        userInfoEntity.userId( userInfoToUserAggregate( userInfo ) );
        userInfoEntity.mobilePhone( userInfoToMobilePhone( userInfo ) );
        userInfoEntity.email( userInfoToEmail( userInfo ) );
        userInfoEntity.id( userInfo.getId() );
        userInfoEntity.displayName( userInfo.getDisplayName() );
        userInfoEntity.sex( userInfo.getSex() );
        userInfoEntity.comments( userInfo.getComments() );

        return userInfoEntity.build();
    }

    private Long aggregateParentIdId(UserAggregate userAggregate) {
        UserAggregate parentId = userAggregate.getParentId();
        if ( parentId == null ) {
            return null;
        }
        return parentId.getId();
    }

    private String aggregateMobilePhoneMobilePhone(UserAggregate userAggregate) {
        MobilePhone mobilePhone = userAggregate.getMobilePhone();
        if ( mobilePhone == null ) {
            return null;
        }
        return mobilePhone.getMobilePhone();
    }

    private String aggregateEmailEmail(UserAggregate userAggregate) {
        Email email = userAggregate.getEmail();
        if ( email == null ) {
            return null;
        }
        return email.getEmail();
    }

    protected UserAggregate userToUserAggregate(User user) {
        if ( user == null ) {
            return null;
        }

        UserAggregate.UserAggregateBuilder<?, ?> userAggregate = UserAggregate.builder();

        userAggregate.id( user.getParentId() );

        return userAggregate.build();
    }

    protected MobilePhone userToMobilePhone(User user) {
        if ( user == null ) {
            return null;
        }

        MobilePhone.MobilePhoneBuilder mobilePhone = MobilePhone.builder();

        mobilePhone.mobilePhone( user.getMobilePhone() );

        return mobilePhone.build();
    }

    protected Email userToEmail(User user) {
        if ( user == null ) {
            return null;
        }

        Email.EmailBuilder email = Email.builder();

        email.email( user.getEmail() );

        return email.build();
    }

    protected UserAggregate userToUserAggregate1(User user) {
        if ( user == null ) {
            return null;
        }

        UserAggregate.UserAggregateBuilder<?, ?> userAggregate = UserAggregate.builder();

        userAggregate.id( user.getParentId() );

        return userAggregate.build();
    }

    protected MobilePhone userToMobilePhone1(User user) {
        if ( user == null ) {
            return null;
        }

        MobilePhone.MobilePhoneBuilder mobilePhone = MobilePhone.builder();

        mobilePhone.mobilePhone( user.getMobilePhone() );

        return mobilePhone.build();
    }

    protected Email userToEmail1(User user) {
        if ( user == null ) {
            return null;
        }

        Email.EmailBuilder email = Email.builder();

        email.email( user.getEmail() );

        return email.build();
    }

    private Long loginProfileUserIdId(LoginProfileEntity loginProfileEntity) {
        UserAggregate userId = loginProfileEntity.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId.getId();
    }

    protected UserAggregate loginProfileToUserAggregate(LoginProfile loginProfile) {
        if ( loginProfile == null ) {
            return null;
        }

        UserAggregate.UserAggregateBuilder<?, ?> userAggregate = UserAggregate.builder();

        userAggregate.id( loginProfile.getUserId() );

        return userAggregate.build();
    }

    private Long userInfoUserIdId(UserInfoEntity userInfoEntity) {
        UserAggregate userId = userInfoEntity.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId.getId();
    }

    private String userInfoMobilePhoneMobilePhone(UserInfoEntity userInfoEntity) {
        MobilePhone mobilePhone = userInfoEntity.getMobilePhone();
        if ( mobilePhone == null ) {
            return null;
        }
        return mobilePhone.getMobilePhone();
    }

    private String userInfoEmailEmail(UserInfoEntity userInfoEntity) {
        Email email = userInfoEntity.getEmail();
        if ( email == null ) {
            return null;
        }
        return email.getEmail();
    }

    protected UserAggregate userInfoToUserAggregate(UserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        UserAggregate.UserAggregateBuilder<?, ?> userAggregate = UserAggregate.builder();

        userAggregate.id( userInfo.getUserId() );

        return userAggregate.build();
    }

    protected MobilePhone userInfoToMobilePhone(UserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        MobilePhone.MobilePhoneBuilder mobilePhone = MobilePhone.builder();

        mobilePhone.mobilePhone( userInfo.getMobilePhone() );

        return mobilePhone.build();
    }

    protected Email userInfoToEmail(UserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        Email.EmailBuilder email = Email.builder();

        email.email( userInfo.getEmail() );

        return email.build();
    }
}
