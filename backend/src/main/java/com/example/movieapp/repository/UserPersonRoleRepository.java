package com.example.movieapp.repository;

import com.example.movieapp.compositekey.UserPersonRoleKey;
import com.example.movieapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserPersonRoleRepository extends JpaRepository<UserPersonRole, UserPersonRoleKey> {

    @Modifying
    @Transactional
    void deleteByUserPerson(UserPerson userPerson);

    List<UserPersonRole> findByUserPerson(UserPerson userPerson);
}
