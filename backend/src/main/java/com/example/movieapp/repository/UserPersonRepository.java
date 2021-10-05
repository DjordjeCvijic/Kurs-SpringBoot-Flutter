package com.example.movieapp.repository;

import com.example.movieapp.model.Season;
import com.example.movieapp.model.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface UserPersonRepository extends JpaRepository<UserPerson, Integer> {
    Optional<UserPerson> findByUsername(String username);

    Optional<UserPerson> findByEmail(String email);
}
