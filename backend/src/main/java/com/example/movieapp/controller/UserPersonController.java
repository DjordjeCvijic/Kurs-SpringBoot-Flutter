package com.example.movieapp.controller;

import com.example.movieapp.dto.UserPersonDto;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.UserPerson;
import com.example.movieapp.service.ContentService;
import com.example.movieapp.service.UserPersonService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-person")
public class UserPersonController {

    @Autowired
    UserPersonService userPersonService;

    @GetMapping()
    public List<UserPerson> getAll() {
        return userPersonService.getAll();
    }

    @PostMapping("/save")
    public UserPerson saveUserPerson(@RequestBody UserPersonDto requestBody) {
        return userPersonService.saveUserPerson(requestBody);
    }

    @PutMapping("/update")
    public UserPerson update(@RequestBody UserPersonDto requestBody) throws NotFoundException {
        return userPersonService.updateUserPerson(requestBody);
    }


    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id) throws NotFoundException {
        userPersonService.deleteUserPersonById(id);
    }



}
