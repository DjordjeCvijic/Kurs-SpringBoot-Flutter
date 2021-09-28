package com.security.jdbcsecurityproject.repository;

import com.security.jdbcsecurityproject.model.Role;
import com.security.jdbcsecurityproject.model.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
