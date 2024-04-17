package com.example.spring_security.Configuration_sec;

import com.example.spring_security.Repos.Repo_User;
import com.example.spring_security.entity.Users;
import com.example.spring_security.services.userService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UsersDetailsService implements UserDetailsService {
    @Autowired
    private  Repo_User repoUser;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Users userTarget = repoUser.findUsersByName(username);

        return new UsersDetails(userTarget);
    }
}
