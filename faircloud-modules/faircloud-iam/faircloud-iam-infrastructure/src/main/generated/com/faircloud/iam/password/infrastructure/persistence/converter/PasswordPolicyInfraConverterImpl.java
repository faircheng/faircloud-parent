package com.faircloud.iam.password.infrastructure.persistence.converter;

import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import com.faircloud.iam.password.infrastructure.persistence.po.PasswordPolicy;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T16:49:36+0800",
    comments = "version: 1.6.0.Beta2, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class PasswordPolicyInfraConverterImpl implements PasswordPolicyInfraConverter {

    @Override
    public PasswordPolicyAggregate to(PasswordPolicy passwordPolicy) {
        if ( passwordPolicy == null ) {
            return null;
        }

        PasswordPolicyAggregate.PasswordPolicyAggregateBuilder<?, ?> passwordPolicyAggregate = PasswordPolicyAggregate.builder();

        passwordPolicyAggregate.userId( passwordPolicyToUserAggregate( passwordPolicy ) );
        passwordPolicyAggregate.id( passwordPolicy.getId() );
        passwordPolicyAggregate.minimumPasswordLength( passwordPolicy.getMinimumPasswordLength() );
        passwordPolicyAggregate.requireLowercaseCharacters( passwordPolicy.getRequireLowercaseCharacters() );
        passwordPolicyAggregate.requireUppercaseCharacters( passwordPolicy.getRequireUppercaseCharacters() );
        passwordPolicyAggregate.requireNumbers( passwordPolicy.getRequireNumbers() );
        passwordPolicyAggregate.requireSymbols( passwordPolicy.getRequireSymbols() );
        passwordPolicyAggregate.hardExpire( passwordPolicy.getHardExpire() );
        passwordPolicyAggregate.maxLoginAttemps( passwordPolicy.getMaxLoginAttemps() );
        passwordPolicyAggregate.passwordReusePrevention( passwordPolicy.getPasswordReusePrevention() );
        passwordPolicyAggregate.maxPasswordAge( passwordPolicy.getMaxPasswordAge() );

        return passwordPolicyAggregate.build();
    }

    @Override
    public PasswordPolicy to(PasswordPolicyAggregate passwordPolicy) {
        if ( passwordPolicy == null ) {
            return null;
        }

        PasswordPolicy.PasswordPolicyBuilder<?, ?> passwordPolicy1 = PasswordPolicy.builder();

        passwordPolicy1.userId( passwordPolicyUserIdId( passwordPolicy ) );
        passwordPolicy1.id( passwordPolicy.getId() );
        passwordPolicy1.minimumPasswordLength( passwordPolicy.getMinimumPasswordLength() );
        passwordPolicy1.requireLowercaseCharacters( passwordPolicy.getRequireLowercaseCharacters() );
        passwordPolicy1.requireUppercaseCharacters( passwordPolicy.getRequireUppercaseCharacters() );
        passwordPolicy1.requireNumbers( passwordPolicy.getRequireNumbers() );
        passwordPolicy1.requireSymbols( passwordPolicy.getRequireSymbols() );
        passwordPolicy1.hardExpire( passwordPolicy.getHardExpire() );
        passwordPolicy1.maxLoginAttemps( passwordPolicy.getMaxLoginAttemps() );
        passwordPolicy1.passwordReusePrevention( passwordPolicy.getPasswordReusePrevention() );
        passwordPolicy1.maxPasswordAge( passwordPolicy.getMaxPasswordAge() );

        return passwordPolicy1.build();
    }

    protected UserAggregate passwordPolicyToUserAggregate(PasswordPolicy passwordPolicy) {
        if ( passwordPolicy == null ) {
            return null;
        }

        UserAggregate.UserAggregateBuilder<?, ?> userAggregate = UserAggregate.builder();

        userAggregate.id( passwordPolicy.getUserId() );

        return userAggregate.build();
    }

    private Long passwordPolicyUserIdId(PasswordPolicyAggregate passwordPolicyAggregate) {
        UserAggregate userId = passwordPolicyAggregate.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId.getId();
    }
}
