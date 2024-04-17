package com.example.spring_security.Configuration_sec;

import com.example.spring_security.entity.Users;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
public class UsersDetails implements UserDetails {

    Users targetUser ;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return targetUser.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return targetUser.getPassword();
    }

    @Override
    public String getUsername() {
        return targetUser.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
