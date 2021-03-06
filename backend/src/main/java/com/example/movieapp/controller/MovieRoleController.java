package com.example.movieapp.controller;


import com.example.movieapp.model.MovieRole;
import com.example.movieapp.service.MovieRoleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie_role")
public class MovieRoleController {
    @Autowired
    MovieRoleService movieRoleService;

    @PostMapping("/save")
    public MovieRole saveMovieRole(@RequestBody MovieRole requestBody) {
        return movieRoleService.saveMovieRole(requestBody);
    }

    @GetMapping("/getAll")
    public List<MovieRole> getAll() {
        return movieRoleService.getAll();
    }

    @PutMapping("/update")
    public MovieRole update(@RequestBody MovieRole requestBody) {
        System.out.println(requestBody.getMovieRoleId());
        return movieRoleService.updateMovieRole(requestBody);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer item) throws NotFoundException {
        movieRoleService.deleteMovieRole(item);
    }
}
