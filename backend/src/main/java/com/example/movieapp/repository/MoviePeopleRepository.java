package com.example.movieapp.repository;
import com.example.movieapp.model.MoviePeople;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePeopleRepository extends JpaRepository<MoviePeople, Integer> {
}
