package com.example.movieapp.controller;

import com.example.movieapp.dto.UserPersonDto;
import com.example.movieapp.dto.UserPersonInfoDto;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.UserPerson;
import com.example.movieapp.service.ContentService;
import com.example.movieapp.service.UserPersonService;
import javassist.NotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-person")
public class UserPersonController {

    @Autowired
    UserPersonService userPersonService;

    @GetMapping("getAll")
    public List<UserPerson> getAll() {
        return userPersonService.getAll();
    }

    @GetMapping
    public UserPerson findById(@RequestParam("id") Integer id) throws NotFoundException {
        return userPersonService.getUserPersonById(id);
    }

    @PostMapping("/save")
    public UserPerson saveUserPerson(@RequestBody UserPersonDto requestBody) {
        return userPersonService.saveUserPerson(requestBody);
    }

    @PutMapping("/update")
    public UserPerson update(@RequestBody UserPersonDto requestBody) throws NotFoundException {
        return userPersonService.updateUserPerson(requestBody);
    }


    @DeleteMapping()
    public void deleteById(@RequestParam("id") Integer id) throws NotFoundException {
        userPersonService.deleteUserPersonById(id);
    }


    @PutMapping("/update-info")
    public UserPerson updateUserPersonInfo(@RequestBody UserPersonInfoDto requestBody) throws NotFoundException {
        return userPersonService.updateUserPersonInfo(requestBody);
    }

}
