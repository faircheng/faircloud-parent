package com.faircloud.iam.user.application.assembler;

import com.faircloud.iam.user.client.module.CreateUserRequest;
import com.faircloud.iam.user.client.module.GetUserResponse;
import com.faircloud.iam.user.client.module.ListUserResponse;
import com.faircloud.iam.user.client.module.RegisterAccountRequest;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.entity.UserInfoEntity;
import com.faircloud.iam.user.domain.model.valueobject.Email;
import com.faircloud.iam.user.domain.model.valueobject.MobilePhone;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T16:49:38+0800",
    comments = "version: 1.6.0.Beta2, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class UserAppConverterImpl implements UserAppConverter {

    @Override
    public GetUserResponse to(UserAggregate aggregate) {
        if ( aggregate == null ) {
            return null;
        }

        GetUserResponse.GetUserResponseBuilder getUserResponse = GetUserResponse.builder();

        Long id = aggregateParentIdId( aggregate );
        if ( id != null ) {
            getUserResponse.parentId( String.valueOf( id ) );
        }
        getUserResponse.mobilePhone( aggregateMobilePhoneMobilePhone( aggregate ) );
        getUserResponse.email( aggregateEmailEmail( aggregate ) );
        if ( aggregate.getId() != null ) {
            getUserResponse.id( String.valueOf( aggregate.getId() ) );
        }
        getUserResponse.userName( aggregate.getUserName() );
        getUserResponse.mobilePhoneIsVerify( aggregate.getMobilePhoneIsVerify() );
        getUserResponse.emailIsVerify( aggregate.getEmailIsVerify() );
        getUserResponse.enabled( aggregate.getEnabled() );
        getUserResponse.description( aggregate.getDescription() );

        return getUserResponse.build();
    }

    @Override
    public UserAggregate to(RegisterAccountRequest cmd) {
        if ( cmd == null ) {
            return null;
        }

        UserAggregate.UserAggregateBuilder<?, ?> userAggregate = UserAggregate.builder();

        userAggregate.mobilePhone( registerAccountRequestToMobilePhone( cmd ) );
        userAggregate.userName( cmd.getUserName() );

        return userAggregate.build();
    }

    @Override
    public ListUserResponse toList(UserAggregate aggregate) {
        if ( aggregate == null ) {
            return null;
        }

        ListUserResponse listUserResponse = new ListUserResponse();

        Long id = aggregateParentIdId( aggregate );
        if ( id != null ) {
            listUserResponse.setParentId( String.valueOf( id ) );
        }
        listUserResponse.setMobilePhone( aggregateMobilePhoneMobilePhone( aggregate ) );
        listUserResponse.setEmail( aggregateEmailEmail( aggregate ) );
        if ( aggregate.getId() != null ) {
            listUserResponse.setId( String.valueOf( aggregate.getId() ) );
        }
        listUserResponse.setUserName( aggregate.getUserName() );
        listUserResponse.setMobilePhoneIsVerify( aggregate.getMobilePhoneIsVerify() );
        listUserResponse.setEmailIsVerify( aggregate.getEmailIsVerify() );
        listUserResponse.setEnabled( aggregate.getEnabled() );
        listUserResponse.setDescription( aggregate.getDescription() );

        return listUserResponse;
    }

    @Override
    public List<ListUserResponse> to(List<UserAggregate> aggregates) {
        if ( aggregates == null ) {
            return null;
        }

        List<ListUserResponse> list = new ArrayList<ListUserResponse>( aggregates.size() );
        for ( UserAggregate userAggregate : aggregates ) {
            list.add( toList( userAggregate ) );
        }

        return list;
    }

    @Override
    public UserInfoEntity to(CreateUserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserInfoEntity.UserInfoEntityBuilder<?, ?> userInfoEntity = UserInfoEntity.builder();

        userInfoEntity.mobilePhone( createUserRequestToMobilePhone( request ) );
        userInfoEntity.email( createUserRequestToEmail( request ) );
        userInfoEntity.displayName( request.getDisplayName() );
        userInfoEntity.comments( request.getComments() );

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

    protected MobilePhone registerAccountRequestToMobilePhone(RegisterAccountRequest registerAccountRequest) {
        if ( registerAccountRequest == null ) {
            return null;
        }

        MobilePhone.MobilePhoneBuilder mobilePhone = MobilePhone.builder();

        mobilePhone.mobilePhone( registerAccountRequest.getMobilePhone() );

        return mobilePhone.build();
    }

    protected MobilePhone createUserRequestToMobilePhone(CreateUserRequest createUserRequest) {
        if ( createUserRequest == null ) {
            return null;
        }

        MobilePhone.MobilePhoneBuilder mobilePhone = MobilePhone.builder();

        mobilePhone.mobilePhone( createUserRequest.getMobilePhone() );

        return mobilePhone.build();
    }

    protected Email createUserRequestToEmail(CreateUserRequest createUserRequest) {
        if ( createUserRequest == null ) {
            return null;
        }

        Email.EmailBuilder email = Email.builder();

        email.email( createUserRequest.getEmail() );

        return email.build();
    }
}
