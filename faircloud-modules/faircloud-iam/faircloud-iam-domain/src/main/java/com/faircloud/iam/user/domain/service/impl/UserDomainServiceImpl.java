package com.faircloud.iam.user.domain.service.impl;

import org.springframework.stereotype.Service;

import com.faircloud.iam.user.domain.persistence.UserPersistence;
import com.faircloud.iam.user.domain.service.UserDomainService;

import lombok.RequiredArgsConstructor;

/**
 * 领域服务 实现类
 *
 * @author Felix Cheng
 */
@Service
@RequiredArgsConstructor
public class UserDomainServiceImpl implements UserDomainService {

    private final UserPersistence userPersistence;
}
