package com.faircloud.platform.auth.module;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

/**
 * custom granted authority
 *
 * @author Felix Cheng
 */
public class CustomGrantedAuthority implements GrantedAuthority {

    private String role;

    public CustomGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
