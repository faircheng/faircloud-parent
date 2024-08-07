package com.faircloud.platform.auth.module;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义用户数据
 *
 * @author Felix Cheng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomUser implements UserDetails {

    private Long id;

    private String password;

    private String username;

    private List<CustomGrantedAuthority> authorities;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;
}
