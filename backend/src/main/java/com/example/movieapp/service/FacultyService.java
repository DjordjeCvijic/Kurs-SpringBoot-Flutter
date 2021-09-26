package com.example.movieapp.service;
import com.example.movieapp.model.Faculty;
import com.example.movieapp.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    public String test(@RequestParam String id) {
        return "This is good" + id;
        //return "This is good";
    }

    public Faculty saveFaculty(@RequestBody Faculty requestBody) {
        System.out.println(requestBody.getFacultyId());
        requestBody.setFacultyId(); // da stavi id koji je random
        return facultyRepository.save(requestBody);
    }

    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Faculty updateFaculty(Faculty item) {
        Faculty faculty = facultyRepository.findById(item.getFacultyId()).get();
        faculty.setName(item.getName());
        facultyRepository.save(faculty);
        return faculty;
    }

    public void deleteFaculty(String facultyId) {
        facultyRepository.deleteById(facultyId);
    }
}
