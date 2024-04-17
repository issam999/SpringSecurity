package com.example.spring_security.services;

import com.example.spring_security.Repos.Repo_Role;
import com.example.spring_security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    Repo_Role repoRole;
    public void addRole ( Role role)
    {
        repoRole.save(role);

    }
}
