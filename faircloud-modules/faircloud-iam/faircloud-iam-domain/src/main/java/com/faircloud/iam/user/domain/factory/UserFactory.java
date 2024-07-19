package com.faircloud.iam.user.domain.factory;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.faircloud.iam.password.domain.service.PasswordPolicyDomainService;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.entity.LoginProfileEntity;
import com.faircloud.iam.user.domain.model.entity.UserInfoEntity;
import com.faircloud.iam.user.domain.model.valueobject.Email;
import com.faircloud.iam.user.domain.model.valueobject.MobilePhone;
import com.faircloud.iam.user.domain.persistence.UserPersistence;
import com.faircloud.platform.common.contants.PlatformConstants;
import com.faircloud.platform.common.enums.StatusCodeEnum;
import com.faircloud.platform.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Factory的主要作用：封装聚合内复杂对象的创建过程，完成聚合根、实体、值对象的创建。
 * 例如，在一个电商系统中，我们可能会有一个订单工厂，它负责创建订单对象。创建订单对象可能需要一些复杂的逻辑，
 * 例如检查库存，计算价格，验证用户信息等。通过使用工厂，我们可以将这些逻辑封装起来，
 * 使得领域层可以更简单地创建订单对象。这样，领域层就可以专注于处理业务逻辑，而不需要关心对象的创建细节。
 *
 * @author Fair Cheng
 */
@Component
@RequiredArgsConstructor
public class UserFactory {

    private final UserPersistence userPersistence;

    private final PasswordEncoder passwordEncoder;

    private final PasswordPolicyDomainService passwordPolicyDomainService;

    public UserAggregate register(String userName, String mobilePhone, String password) {
        UserAggregate aggregate = new UserAggregate(IdWorker.getId());
        LoginProfileEntity loginProfile = LoginProfileEntity.builder()
                .id(IdWorker.getId())
                .userId(aggregate)
                .password(passwordEncoder.encode(password))
                .build();
        UserInfoEntity userInfo = UserInfoEntity.builder()
                .id(IdWorker.getId())
                .userId(aggregate)
                .displayName(PlatformConstants.DEFAULT_USER_NAME + aggregate.getId())
                .mobilePhone(new MobilePhone(mobilePhone))
                .build();
        aggregate.register(userName, new MobilePhone(mobilePhone), loginProfile, userInfo);
        // 用户密码强度策略 校验
        passwordPolicyDomainService.valid(password, new UserAggregate(1L));
        // 用户名 校验
        if (userPersistence.checkUserName(aggregate.getUserName(), aggregate.getId())) {
            throw new BusinessException(StatusCodeEnum.A0111);
        }
        // 手机号校验
        if (userPersistence.checkMobilePhone(aggregate.getMobilePhone(), aggregate.getId())) {
            throw new BusinessException(StatusCodeEnum.A0151);
        }
        return aggregate;
    }

    public UserAggregate mobileReg(String mobilePhone) {
        UserAggregate aggregate = new UserAggregate(IdWorker.getId());
        LoginProfileEntity loginProfile = LoginProfileEntity.builder()
                .id(IdWorker.getId())
                .userId(aggregate)
                .password(passwordEncoder.encode(PlatformConstants.DEFAULT_PWD))
                .build();
        UserInfoEntity userInfo = UserInfoEntity.builder()
                .id(IdWorker.getId())
                .userId(aggregate)
                .displayName(PlatformConstants.DEFAULT_USER_NAME + aggregate.getId())
                .mobilePhone(new MobilePhone(mobilePhone))
                .build();
        aggregate.mobileReg(new MobilePhone(mobilePhone), loginProfile, userInfo);
        // 手机号校验
        if (userPersistence.checkMobilePhone(aggregate.getMobilePhone(), aggregate.getId())) {
            throw new BusinessException(StatusCodeEnum.A0151);
        }
        return aggregate;
    }

    public UserAggregate createUser(String userName, String displayName, String mobilePhone, String email, String comments) {

        UserAggregate aggregate = new UserAggregate(IdWorker.getId());
        LoginProfileEntity loginProfile = LoginProfileEntity.builder()
                .id(IdWorker.getId())
                .userId(aggregate)
                .password(passwordEncoder.encode(PlatformConstants.DEFAULT_PWD))
                .build();
        UserInfoEntity userInfo = UserInfoEntity.builder()
                .id(IdWorker.getId())
                .userId(aggregate)
                .displayName(displayName)
                .mobilePhone(new MobilePhone(mobilePhone))
                .email(new Email(email))
                .comments(comments)
                .build();
        // 用户名 校验
        if (userPersistence.checkUserName(aggregate.getUserName(), aggregate.getId())) {
            throw new BusinessException(StatusCodeEnum.A0111);
        }
        aggregate.createUser(new UserAggregate(1L), userName, loginProfile, userInfo);
        return aggregate;
    }
}
