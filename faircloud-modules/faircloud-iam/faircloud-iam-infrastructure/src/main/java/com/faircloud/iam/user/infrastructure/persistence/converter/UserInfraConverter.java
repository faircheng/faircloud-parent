package com.faircloud.iam.user.infrastructure.persistence.converter;

import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.entity.LoginProfileEntity;
import com.faircloud.iam.user.domain.model.entity.UserInfoEntity;
import com.faircloud.iam.user.infrastructure.persistence.po.LoginProfile;
import com.faircloud.iam.user.infrastructure.persistence.po.User;
import com.faircloud.iam.user.infrastructure.persistence.po.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 自动装配
 *
 * @author Fair Cheng
 */
@Mapper
public interface UserInfraConverter {

    UserInfraConverter INSTANCE = Mappers.getMapper(UserInfraConverter.class);

    @Mappings({
            @Mapping(source = "parentId.id", target = "parentId"),
            @Mapping(source = "mobilePhone.mobilePhone", target = "mobilePhone"),
            @Mapping(source = "email.email", target = "email")
    })
    User to(UserAggregate aggregate);

    @Mappings({
            @Mapping(source = "parentId", target = "parentId.id"),
            @Mapping(source = "mobilePhone", target = "mobilePhone.mobilePhone"),
            @Mapping(source = "email", target = "email.email")
    })
    UserAggregate to(User user);

    @Mappings({
            @Mapping(source = "user.id", target = "id"),
            @Mapping(source = "user.parentId", target = "parentId.id"),
            @Mapping(source = "user.mobilePhone", target = "mobilePhone.mobilePhone"),
            @Mapping(source = "user.email", target = "email.email"),
            @Mapping(source = "user.enabled", target = "enabled")
    })
    UserAggregate to(User user, LoginProfile loginProfile, UserInfo userInfo);

    List<UserAggregate> to(List<User> userList);

    @Mapping(source = "userId.id", target = "userId")
    LoginProfile to(LoginProfileEntity loginProfile);

    @Mapping(source = "userId", target = "userId.id")
    LoginProfileEntity to(LoginProfile loginProfile);

    @Mappings({
            @Mapping(source = "userId.id", target = "userId"),
            @Mapping(source = "mobilePhone.mobilePhone", target = "mobilePhone"),
            @Mapping(source = "email.email", target = "email")
    })
    UserInfo to(UserInfoEntity userInfo);

    @Mappings({
            @Mapping(source = "userId", target = "userId.id"),
            @Mapping(source = "mobilePhone", target = "mobilePhone.mobilePhone"),
            @Mapping(source = "email", target = "email.email")
    })
    UserInfoEntity to(UserInfo userInfo);
}
