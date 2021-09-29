package com.example.movieapp.service;

import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentGenre;
import com.example.movieapp.model.UserPerson;
import com.example.movieapp.model.UserPersonRole;
import com.example.movieapp.repository.ContentGenreRepository;
import com.example.movieapp.repository.UserPersonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserPersonRoleService {

    @Autowired
    UserPersonRoleRepository userPersonRoleRepository;

    public UserPersonRole saveUserPersonRole(@RequestBody UserPersonRole requestBody) {
        return userPersonRoleRepository.save(requestBody);
    }

    public List<UserPersonRole> getAll() {
        return userPersonRoleRepository.findAll();
    }

    public void deleteUserPersonRoleByUser(UserPerson userPerson) {
        userPersonRoleRepository.deleteByUserPerson(userPerson);
    }
}
