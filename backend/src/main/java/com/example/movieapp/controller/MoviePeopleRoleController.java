package com.example.movieapp.controller;

import com.example.movieapp.model.MoviePeopleRole;
import com.example.movieapp.model.MoviePeopleRoleId;
import com.example.movieapp.model.UserPerson;
import com.example.movieapp.service.MoviePeopleRoleService;
import com.example.movieapp.service.UserPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-people-role")
public class MoviePeopleRoleController {

    @Autowired
    MoviePeopleRoleService moviePeopleRoleService;

    @GetMapping()
    public List<MoviePeopleRole> getAll() {
        return moviePeopleRoleService.getAll();
    }

    @PostMapping("/save")
    public  MoviePeopleRole saveUserPerson(@RequestBody  MoviePeopleRole requestBody) {
        return moviePeopleRoleService.saveMoviePeopleRole(requestBody);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam MoviePeopleRoleId moviePeopleRoleId) {
        moviePeopleRoleService.deleteMoviePeopleRole(moviePeopleRoleId);
    }
}
