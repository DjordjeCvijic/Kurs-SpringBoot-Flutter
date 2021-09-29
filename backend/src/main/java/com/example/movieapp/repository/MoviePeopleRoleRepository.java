package com.example.movieapp.repository;

import com.example.movieapp.model.MoviePeople;
import com.example.movieapp.model.MoviePeopleRole;
import com.example.movieapp.model.MovieRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePeopleRoleRepository extends JpaRepository<MoviePeopleRole, Integer> {
    boolean existsByMovieRoleAndMoviePeople(MovieRole movieRole, MoviePeople moviePeople);
}
