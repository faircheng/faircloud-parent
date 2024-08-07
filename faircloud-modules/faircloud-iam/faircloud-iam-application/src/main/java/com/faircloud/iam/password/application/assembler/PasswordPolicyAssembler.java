package com.faircloud.iam.password.application.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import com.faircloud.iam.settings.client.module.GetPasswordPolicyResponse;
import com.faircloud.iam.settings.client.module.SetPasswordPolicyRequest;

/**
 * 组装器，DTO <---> Entity，用于Application层
 *
 * @author Felix Cheng
 */
@Mapper
public interface PasswordPolicyAssembler {

    PasswordPolicyAssembler INSTANCE = Mappers.getMapper(PasswordPolicyAssembler.class);

    @Mappings({
            @Mapping(target = "id", expression = "java(com.baomidou.mybatisplus.core.toolkit.IdWorker.getId())"),
            @Mapping(target = "userId.id", source = "userId")
    })
    PasswordPolicyAggregate to(Long userId, SetPasswordPolicyRequest request);

    PasswordPolicyAggregate to(SetPasswordPolicyRequest request, @MappingTarget PasswordPolicyAggregate aggregate);

    GetPasswordPolicyResponse to(PasswordPolicyAggregate aggregate);
}
