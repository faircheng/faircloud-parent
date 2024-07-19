package com.faircloud.iam.user.domain.persistence;

import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.iam.user.domain.model.entity.LoginProfileEntity;

public interface LoginProfilePersistence {

    LoginProfileEntity getByUserId(UserAggregate user);
}
