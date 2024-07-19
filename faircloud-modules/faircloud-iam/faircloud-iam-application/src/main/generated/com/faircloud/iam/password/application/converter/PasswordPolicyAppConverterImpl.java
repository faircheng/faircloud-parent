package com.faircloud.iam.password.application.converter;

import com.faircloud.iam.password.client.module.GetPasswordPolicyResponse;
import com.faircloud.iam.password.client.module.SetPasswordPolicyRequest;
import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T16:49:38+0800",
    comments = "version: 1.6.0.Beta2, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class PasswordPolicyAppConverterImpl implements PasswordPolicyAppConverter {

    @Override
    public PasswordPolicyAggregate to(Long userId, SetPasswordPolicyRequest request) {
        if ( userId == null && request == null ) {
            return null;
        }

        PasswordPolicyAggregate.PasswordPolicyAggregateBuilder<?, ?> passwordPolicyAggregate = PasswordPolicyAggregate.builder();

        if ( request != null ) {
            passwordPolicyAggregate.minimumPasswordLength( request.getMinimumPasswordLength() );
            passwordPolicyAggregate.requireLowercaseCharacters( request.getRequireLowercaseCharacters() );
            passwordPolicyAggregate.requireUppercaseCharacters( request.getRequireUppercaseCharacters() );
            passwordPolicyAggregate.requireNumbers( request.getRequireNumbers() );
            passwordPolicyAggregate.requireSymbols( request.getRequireSymbols() );
            passwordPolicyAggregate.hardExpire( request.getHardExpire() );
            passwordPolicyAggregate.maxLoginAttemps( request.getMaxLoginAttemps() );
            passwordPolicyAggregate.passwordReusePrevention( request.getPasswordReusePrevention() );
            passwordPolicyAggregate.maxPasswordAge( request.getMaxPasswordAge() );
        }
        passwordPolicyAggregate.userId( longToUserAggregate( userId ) );
        passwordPolicyAggregate.id( com.baomidou.mybatisplus.core.toolkit.IdWorker.getId() );

        return passwordPolicyAggregate.build();
    }

    @Override
    public PasswordPolicyAggregate to(SetPasswordPolicyRequest request, PasswordPolicyAggregate aggregate) {
        if ( request == null ) {
            return aggregate;
        }

        aggregate.setMinimumPasswordLength( request.getMinimumPasswordLength() );
        aggregate.setRequireLowercaseCharacters( request.getRequireLowercaseCharacters() );
        aggregate.setRequireUppercaseCharacters( request.getRequireUppercaseCharacters() );
        aggregate.setRequireNumbers( request.getRequireNumbers() );
        aggregate.setRequireSymbols( request.getRequireSymbols() );
        aggregate.setHardExpire( request.getHardExpire() );
        aggregate.setMaxLoginAttemps( request.getMaxLoginAttemps() );
        aggregate.setPasswordReusePrevention( request.getPasswordReusePrevention() );
        aggregate.setMaxPasswordAge( request.getMaxPasswordAge() );

        return aggregate;
    }

    @Override
    public GetPasswordPolicyResponse to(PasswordPolicyAggregate aggregate) {
        if ( aggregate == null ) {
            return null;
        }

        GetPasswordPolicyResponse.GetPasswordPolicyResponseBuilder getPasswordPolicyResponse = GetPasswordPolicyResponse.builder();

        getPasswordPolicyResponse.id( aggregate.getId() );
        getPasswordPolicyResponse.minimumPasswordLength( aggregate.getMinimumPasswordLength() );
        getPasswordPolicyResponse.requireLowercaseCharacters( aggregate.getRequireLowercaseCharacters() );
        getPasswordPolicyResponse.requireUppercaseCharacters( aggregate.getRequireUppercaseCharacters() );
        getPasswordPolicyResponse.requireNumbers( aggregate.getRequireNumbers() );
        getPasswordPolicyResponse.requireSymbols( aggregate.getRequireSymbols() );
        getPasswordPolicyResponse.hardExpire( aggregate.getHardExpire() );
        getPasswordPolicyResponse.maxLoginAttemps( aggregate.getMaxLoginAttemps() );
        getPasswordPolicyResponse.passwordReusePrevention( aggregate.getPasswordReusePrevention() );
        getPasswordPolicyResponse.maxPasswordAge( aggregate.getMaxPasswordAge() );

        return getPasswordPolicyResponse.build();
    }

    protected UserAggregate longToUserAggregate(Long long1) {
        if ( long1 == null ) {
            return null;
        }

        UserAggregate.UserAggregateBuilder<?, ?> userAggregate = UserAggregate.builder();

        userAggregate.id( long1 );

        return userAggregate.build();
    }
}
