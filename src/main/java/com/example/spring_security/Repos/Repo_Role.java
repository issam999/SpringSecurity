package com.example.spring_security.Repos;

import com.example.spring_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo_Role extends JpaRepository<Role,Long> {
}
