package com.faircloud.iam.user.application.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.ListUserResponse;
import com.faircloud.iam.user.client.module.LoadUserResponse;
import com.faircloud.iam.user.client.module.RegisterAccountRequest;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.entity.UserInfoEntity;

/**
 * 用户 转换器
 *
 * @author Fair Cheng
 */
@Mapper
public interface UserAppConverter {

    UserAppConverter INSTANCE = Mappers.getMapper(UserAppConverter.class);

    @Mappings({@Mapping(source = "parentId.id", target = "parentId"),
        @Mapping(source = "mobilePhone.mobilePhone", target = "mobilePhone"),
        @Mapping(source = "email.email", target = "email")})
    GetUserResponse to(UserAggregate aggregate);

    @Mappings({@Mapping(source = "parentId.id", target = "parentId"),
        @Mapping(source = "mobilePhone.mobilePhone", target = "mobilePhone"),
        @Mapping(source = "email.email", target = "email"),
        @Mapping(source = "loginProfile.password", target = "password")})
    LoadUserResponse load(UserAggregate aggregate);

    @Mappings({@Mapping(source = "mobilePhone", target = "mobilePhone.mobilePhone")})
    UserAggregate to(RegisterAccountRequest cmd);

    @Mappings({@Mapping(source = "parentId.id", target = "parentId"),
        @Mapping(source = "mobilePhone.mobilePhone", target = "mobilePhone"),
        @Mapping(source = "email.email", target = "email")})
    ListUserResponse toList(UserAggregate aggregate);

    List<ListUserResponse> to(List<UserAggregate> aggregates);

    @Mappings({@Mapping(source = "mobilePhone", target = "mobilePhone.mobilePhone"),
        @Mapping(source = "email", target = "email.email")})
    UserInfoEntity to(CreateUserRequest request);
}
