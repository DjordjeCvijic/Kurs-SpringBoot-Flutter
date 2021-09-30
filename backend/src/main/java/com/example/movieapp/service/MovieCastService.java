package com.example.movieapp.service;

import com.example.movieapp.model.Content;
import com.example.movieapp.model.MovieCast;
import com.example.movieapp.repository.MovieCastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieCastService {

    @Autowired
    MovieCastRepository movieCastRepository;


    public MovieCast saveMovieCast(MovieCast movieCast){
        return movieCastRepository.save(movieCast);
    }

    public void deleteMovieCastByContent(Content content) {
        movieCastRepository.deleteByContent(content);
    }
}
