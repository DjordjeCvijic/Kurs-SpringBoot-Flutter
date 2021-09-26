package com.example.movieapp.service;


import com.example.movieapp.model.MovieRole;
import com.example.movieapp.repository.MovieRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieRoleService {
    @Autowired
    MovieRoleRepository movieRoleRepository;

    public MovieRole saveMovieRole(@RequestBody MovieRole requestBody) {
        System.out.println(requestBody.getMovieRoleId());
        return movieRoleRepository.save(requestBody);
    }

    public List<MovieRole> getAll() {
        return movieRoleRepository.findAll();
    }

    public MovieRole updateMovieRole(MovieRole item) {
        MovieRole movieRole=movieRoleRepository.findById(item.getMovieRoleId()).get();
        movieRole.setName(item.getName());
        movieRoleRepository.save(movieRole);
        return movieRole;
    }

    public void deleteMovieRole(Integer movieRoleId) {
        movieRoleRepository.deleteById(movieRoleId);
    }
}
