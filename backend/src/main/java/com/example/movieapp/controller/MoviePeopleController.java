package com.example.movieapp.controller;

import com.example.movieapp.dto.MoviePeopleDto;
import com.example.movieapp.model.MoviePeople;
import com.example.movieapp.service.MoviePeopleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-people")
public class MoviePeopleController {
    @Autowired
    MoviePeopleService moviePeopleService;

    @PostMapping("/save")
    public MoviePeople saveMoviePeople(@RequestBody MoviePeopleDto requestBody) {
        return moviePeopleService.saveMoviePeople(requestBody);
    }

    @GetMapping("getAll")
    public List<MoviePeople> getAll() {
        return moviePeopleService.getAll();
    }

    @GetMapping()
    public MoviePeople findById(@RequestParam("id") Integer id) throws NotFoundException {
        return moviePeopleService.getMoviePeopleById(id);
    }

    @PutMapping("/update")
    public MoviePeople update(@RequestBody MoviePeople requestBody) throws NotFoundException {
        return moviePeopleService.updateMoviePeople(requestBody);
    }


    @DeleteMapping()
    public void delete(@RequestParam("id") Integer id) throws NotFoundException {
        moviePeopleService.deleteMoviePeople(id);
    }
}
