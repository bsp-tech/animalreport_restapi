package com.company.imtahan.service;

import com.company.imtahan.entities.User;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

    private final User user;

    public CustomUserDetails(
            String username, 
            String password, 
            boolean enabled,
            Collection<? extends GrantedAuthority> authorities, 
            User user) {
        super(username, password, enabled, true, true, true, authorities);
        this.user = user;
    }
    
    public User getUser(){
        return this.user;
    }
}
