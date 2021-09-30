package com.security.jdbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.jdbc.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
