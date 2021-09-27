package com.example.movieapp.service;

import com.example.movieapp.model.Season;
import com.example.movieapp.model.UserPerson;
import com.example.movieapp.repository.SeasonRepository;
import com.example.movieapp.repository.UserPersonRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserPersonService {
    @Autowired
    UserPersonRepository userPersonRepository;

    public UserPerson saveUserPerson(@RequestBody UserPerson requestBody) {
        return userPersonRepository.save(requestBody);
    }

    public List<UserPerson> getAll() {
        return userPersonRepository.findAll();
    }

    public UserPerson updateUserPerson(UserPerson userPerson) {
        UserPerson userPersonToUpdate=userPersonRepository.findById(userPerson.getUserId()).get();
        userPersonToUpdate.setUserName(userPerson.getUserName());
        userPersonToUpdate.setFirstName(userPerson.getFirstName());
        userPersonToUpdate.setLastName(userPerson.getLastName());
        userPersonToUpdate.setAddress(userPerson.getAddress());
        userPersonToUpdate.setPhoneNumber(userPerson.getPhoneNumber());
        userPersonToUpdate.setEmail(userPerson.getEmail());
        userPersonToUpdate.setPassword(userPerson.getPassword());
        userPersonRepository.save(userPersonToUpdate);
        return userPerson;
    }

    public void deleteUserPerson(Integer userPersonId) {
        userPersonRepository.deleteById(userPersonId);
    }
}
