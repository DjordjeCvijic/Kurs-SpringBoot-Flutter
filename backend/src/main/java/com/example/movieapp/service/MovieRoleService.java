package com.example.movieapp.service;


import com.example.movieapp.model.Genre;
import com.example.movieapp.model.MovieRole;
import com.example.movieapp.model.Season;
import com.example.movieapp.repository.MovieRoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieRoleService {
    @Autowired
    MovieRoleRepository movieRoleRepository;

    public MovieRole saveMovieRole(MovieRole requestBody) {
        return movieRoleRepository.save(requestBody);
    }

    public List<MovieRole> getAll() {
        return movieRoleRepository.findAll();
    }

    public MovieRole updateMovieRole(MovieRole item) {
        MovieRole movieRole = movieRoleRepository.findById(item.getMovieRoleId()).get();
        movieRole.setName(item.getName());
        movieRoleRepository.save(movieRole);
        return movieRole;
    }

    public MovieRole getMovieRoleById(Integer id) throws NotFoundException {
        return movieRoleRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađen movie role sa id-em:" + id));
    }

    public void deleteMovieRole(Integer movieRoleId) throws NotFoundException {
        if (movieRoleRepository.existsById(movieRoleId)) {
            movieRoleRepository.deleteById(movieRoleId);

        }
        throw new NotFoundException("Nije pronađen movie role sa id-em:" + movieRoleId);

    }
}
