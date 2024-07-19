package com.faircloud.iam.password.infrastructure.persistence.converter;

import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import com.faircloud.iam.password.infrastructure.persistence.po.PasswordPolicy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 用户密码强度等策略信息 infrastructure 转换器
 *
 * @author Fair Cheng
 */
@Mapper
public interface PasswordPolicyInfraConverter {

    PasswordPolicyInfraConverter INSTANCE = Mappers.getMapper(PasswordPolicyInfraConverter.class);

    @Mapping(source = "userId", target = "userId.id")
    PasswordPolicyAggregate to(PasswordPolicy passwordPolicy);

    @Mapping(source = "userId.id", target = "userId")
    PasswordPolicy to(PasswordPolicyAggregate passwordPolicy);
}
