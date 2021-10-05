package com.example.movieapp.service;

import com.example.movieapp.model.Content;
import com.example.movieapp.model.MovieCast;
import com.example.movieapp.model.Season;
import com.example.movieapp.model.SerieCast;
import com.example.movieapp.repository.MovieCastRepository;
import com.example.movieapp.repository.SerieCastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieCastService {
    @Autowired
    SerieCastRepository serieCastRepository;


    public SerieCast saveSerieCast(SerieCast serieCast) {
        return serieCastRepository.save(serieCast);
    }

    public void deleteSerieCastBySeason(Season season) {
        serieCastRepository.deleteBySeason(season);
    }
}
