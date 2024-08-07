package com.faircloud.iam.password.domain.persistence;

import com.faircloud.iam.password.domain.model.aggregate.PasswordPolicyAggregate;
import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
import com.faircloud.platform.common.module.Response;
import com.faircloud.platform.common.persistence.Persistence;

/**
 * 用户密码强度等策略信息 持久化接口
 *
 * @author Felix Cheng
 */
public interface PasswordPolicyPersistence extends Persistence {

    PasswordPolicyAggregate getPasswordPolicy(UserAggregate aggregate);

    void save(PasswordPolicyAggregate aggregate);
}
