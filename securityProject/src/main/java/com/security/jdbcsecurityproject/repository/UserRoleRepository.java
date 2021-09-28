package com.security.jdbcsecurityproject.repository;

import com.security.jdbcsecurityproject.model.UserPerson;
import com.security.jdbcsecurityproject.model.UserRole;
import com.security.jdbcsecurityproject.model.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
    void deleteByUserPerson(UserPerson byId);

    List<UserRole> findByUserPerson(UserPerson userPerson);


}
