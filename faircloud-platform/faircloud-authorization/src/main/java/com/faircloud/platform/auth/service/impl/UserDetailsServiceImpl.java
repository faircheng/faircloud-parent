package com.faircloud.platform.auth.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.faircloud.iam.user.client.api.UserClient;
import com.faircloud.iam.user.client.module.LoadUserByUsernameRequest;
import com.faircloud.iam.user.client.module.LoadUserResponse;
import com.faircloud.platform.auth.module.CustomGrantedAuthority;
import com.faircloud.platform.auth.module.CustomUser;

import lombok.RequiredArgsConstructor;

/**
 * User Details Service Impl
 *
 * @author Felix Cheng
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoadUserResponse user = userClient.loadUserByUsername(LoadUserByUsernameRequest.builder().userName(username).build()).getData();

        List<CustomGrantedAuthority> grantedAuthorityList = Arrays.asList("USER").stream().map(CustomGrantedAuthority::new).collect(Collectors.toList());

        CustomUser custom = CustomUser.builder()
            .id(user.getId())
            .username(user.getUserName())
            .password(user.getPassword())
            .enabled(user.getEnabled())
            .credentialsNonExpired(user.getCredentialsNonExpired())
            .accountNonExpired(user.getAccountNonExpired())
            .accountNonLocked(user.getAccountNonLocked())
            .authorities(grantedAuthorityList)
            .build();

        return custom;
    }
}
