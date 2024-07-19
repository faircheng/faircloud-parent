//package com.faircloud.platform.auth.service.impl;
//
//import com.faircloud.iam.user.domain.model.aggregate.UserAggregate;
//import com.faircloud.iam.user.domain.model.entity.LoginProfileEntity;
//import com.faircloud.iam.user.domain.persistence.UserPersistence;
//import com.faircloud.platform.common.exception.Assert;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * User Details Service Impl
// *
// * @author Fair Cheng
// */
//@Service
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserPersistence userPersistence;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserAggregate aggregate = userPersistence.loadUserByUsername(username);
//        Assert.notNull(aggregate, "");
//        LoginProfileEntity loginProfile = aggregate.getLoginProfile();
//        Assert.notNull(loginProfile, "");
//        List<SimpleGrantedAuthority> grantedAuthorityList = Arrays.asList("USER").stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//
//        return User.builder().username(aggregate.getUserName()).password(loginProfile.getPassword()).authorities(grantedAuthorityList).build();
//    }
//}
