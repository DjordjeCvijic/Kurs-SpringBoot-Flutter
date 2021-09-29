package com.example.movieapp.repository;

import com.example.movieapp.model.MovieRole;
import com.example.movieapp.model.Role;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
