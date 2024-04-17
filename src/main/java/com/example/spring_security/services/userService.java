package com.example.spring_security.services;


import com.example.spring_security.Repos.Repo_User;
import com.example.spring_security.entity.Role;
import com.example.spring_security.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Component
public class userService {

    @Autowired
    Repo_User repoUser;

    public List<Users> getAllUser ( )
    {
        return repoUser.findAll();
    }

    public void addUser (Users users)
    {
        repoUser.save(users);
    }


}
