package com.faircloud.iam.user.domain.service.impl;

import com.faircloud.iam.user.domain.persistence.UserPersistence;
import com.faircloud.iam.user.domain.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 领域服务 实现类
 *
 * @author Fair Cheng
 */
@Service
@RequiredArgsConstructor
public class UserDomainServiceImpl implements UserDomainService {

    private final UserPersistence userPersistence;
}
