package com.security.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.jwt.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
