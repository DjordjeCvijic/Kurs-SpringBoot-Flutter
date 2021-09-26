package com.example.movieapp.controller;

import com.example.movieapp.model.Faculty;
import com.example.movieapp.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping("/test")
    public String test(@RequestParam String id) {
        return "This is good" + id ;
        //return "This is good";
    }

    @PostMapping("save")
    public Faculty saveFaculty(@RequestBody Faculty requestBody) {
        return facultyService.saveFaculty(requestBody);
    }

    @GetMapping()
    public List<Faculty> getAll() {
        return facultyService.getAll();
    }

    @PutMapping("/update")
    public Faculty update(@RequestBody Faculty requestBody) {
        System.out.println(requestBody.getFacultyId());
        return facultyService.updateFaculty(requestBody);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String item) {
        facultyService.deleteFaculty(item);
    }
}
