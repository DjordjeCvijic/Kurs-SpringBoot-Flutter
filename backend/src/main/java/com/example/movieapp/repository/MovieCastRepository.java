package com.example.movieapp.repository;

import com.example.movieapp.compositekey.MovieCastKey;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.Language;
import com.example.movieapp.model.MovieCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCastRepository extends JpaRepository<MovieCast, MovieCastKey> {
    void deleteByContent(Content content);
}
