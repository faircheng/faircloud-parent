package com.faircloud.platform.auth.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.faircloud.iam.user.client.api.UserClient;
import com.faircloud.iam.user.client.module.LoadUserResponse;

import lombok.RequiredArgsConstructor;

/**
 * User Details Service Impl
 *
 * @author Fair Cheng
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoadUserResponse user = userClient.loadUserByUsername(username).getData();

        List<SimpleGrantedAuthority> grantedAuthorityList = Arrays.asList("USER").stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return User.builder().username(user.getUserName()).password(user.getPassword()).authorities(grantedAuthorityList).build();
    }
}
