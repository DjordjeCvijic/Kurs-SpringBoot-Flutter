package com.example.movieapp.service;


import com.example.movieapp.model.MoviePeopleRole;
import com.example.movieapp.model.MoviePeopleRoleId;
import com.example.movieapp.model.UserPerson;
import com.example.movieapp.repository.MoviePeopleRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MoviePeopleRoleService {

    @Autowired
    MoviePeopleRoleRepository moviePeopleRoleRepository;

    public MoviePeopleRole saveMoviePeopleRole(@RequestBody MoviePeopleRole requestBody) {
        return moviePeopleRoleRepository.save(requestBody);
    }

    public List<MoviePeopleRole> getAll() {
        return moviePeopleRoleRepository.findAll();
    }

    public void deleteMoviePeopleRole(MoviePeopleRoleId id) {
        moviePeopleRoleRepository.deleteById(id);
    }


}
