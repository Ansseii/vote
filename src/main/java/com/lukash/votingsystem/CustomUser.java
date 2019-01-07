package com.lukash.votingsystem;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    private final Integer userId;

    public CustomUser(final String username, final String password,
                      final Collection<? extends GrantedAuthority> authorities, final int userId) {
        super(username, password, authorities);
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
