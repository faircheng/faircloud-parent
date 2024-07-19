package com.faircloud.iam.password.application.converter;

import com.faircloud.iam.password.client.module.GetPasswordPolicyResponse;
import com.faircloud.iam.password.client.module.SetPasswordPolicyRequest;
import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 用户 转换器
 *
 * @author Fair Cheng
 */
@Mapper
public interface PasswordPolicyAppConverter {

    PasswordPolicyAppConverter INSTANCE = Mappers.getMapper(PasswordPolicyAppConverter.class);

    @Mappings({
            @Mapping(target = "id", expression = "java(com.baomidou.mybatisplus.core.toolkit.IdWorker.getId())"),
            @Mapping(target = "userId.id", source = "userId")
    })
    PasswordPolicyAggregate to(Long userId, SetPasswordPolicyRequest request);

    PasswordPolicyAggregate to(SetPasswordPolicyRequest request, @MappingTarget PasswordPolicyAggregate aggregate);

    GetPasswordPolicyResponse to(PasswordPolicyAggregate aggregate);
}
