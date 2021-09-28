package com.security.jdbcsecurityproject.repository;


import com.security.jdbcsecurityproject.model.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPersonRepository extends JpaRepository<UserPerson, Integer> {
    Optional<UserPerson> findByUsername(String username);
}
