package com.example.movieapp.repository;

import com.example.movieapp.model.MoviePeopleRole;
import com.example.movieapp.model.MoviePeopleRoleId;
import com.example.movieapp.model.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePeopleRoleRepository extends JpaRepository<MoviePeopleRole, MoviePeopleRoleId> {
}
