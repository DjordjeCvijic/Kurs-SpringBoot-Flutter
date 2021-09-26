package com.example.movieapp.controller;

import com.example.movieapp.model.MoviePeople;
import com.example.movieapp.service.MoviePeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie_people")
public class MoviePeopleController {
    @Autowired
    MoviePeopleService moviePeopleService;

    @PostMapping("save")
    public MoviePeople saveMoviePeople(@RequestBody MoviePeople requestBody) {
        return moviePeopleService.saveMoviePeople(requestBody);
    }

    @GetMapping()
    public List<MoviePeople> getAll() {
        return moviePeopleService.getAll();
    }

    @PutMapping("/update")
    public MoviePeople update(@RequestBody MoviePeople requestBody) {
        System.out.println(requestBody.getMoviePeopleId());
        return moviePeopleService.updateMoviePeople(requestBody);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer item) {
        moviePeopleService.deleteMoviePeople(item);
    }
}
