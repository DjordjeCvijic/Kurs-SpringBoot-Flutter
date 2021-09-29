package com.example.movieapp.service;


import com.example.movieapp.model.MoviePeopleRole;
import com.example.movieapp.repository.MoviePeopleRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MoviePeopleRoleService {

    @Autowired
    MoviePeopleRoleRepository moviePeopleRoleRepository;

    public MoviePeopleRole saveMoviePeopleRole(@RequestBody MoviePeopleRole requestBody) throws Exception {
        if (!moviePeopleRoleRepository.existsByMovieRoleAndMoviePeople(requestBody.getMovieRole(), requestBody.getMoviePeople()))
            return moviePeopleRoleRepository.save(requestBody);
        throw new Exception("MoviePeople - Role vec postoji");
    }

    public List<MoviePeopleRole> getAll() {
        return moviePeopleRoleRepository.findAll();
    }

    public void deleteMoviePeopleRole(Integer id) {
        moviePeopleRoleRepository.deleteById(id);
    }


}
