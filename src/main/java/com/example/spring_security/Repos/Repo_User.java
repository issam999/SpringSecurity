package com.example.spring_security.Repos;

import com.example.spring_security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface  Repo_User extends JpaRepository<Users, Long> {


    Users findUsersByName(String username);

    Object findUsersByName(Object name);
}
