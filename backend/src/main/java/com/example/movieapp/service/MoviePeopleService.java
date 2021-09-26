package com.example.movieapp.service;


import com.example.movieapp.model.MoviePeople;
import com.example.movieapp.repository.MoviePeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MoviePeopleService {
    @Autowired
    MoviePeopleRepository moviePeopleRepository;

    public MoviePeople saveMoviePeople(@RequestBody MoviePeople requestBody) {
        System.out.println(requestBody.getMoviePeopleId());
        return moviePeopleRepository.save(requestBody);
    }

    public List<MoviePeople> getAll() {
        return moviePeopleRepository.findAll();
    }

    public MoviePeople updateMoviePeople(MoviePeople item) {
        MoviePeople moviePeople=moviePeopleRepository.findById(item.getMoviePeopleId()).get();
        moviePeople.setFirstName(item.getFirstName());
        moviePeopleRepository.save(moviePeople);
        return moviePeople;
    }

    public void deleteMoviePeople(Integer moviePeopleId) {
        moviePeopleRepository.deleteById(moviePeopleId);
    }
}
