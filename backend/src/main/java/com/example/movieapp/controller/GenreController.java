package com.example.movieapp.controller;

import com.example.movieapp.model.Genre;
import com.example.movieapp.service.GenreService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreService genreService;

    @PostMapping("/save")
    public Genre saveGenre(@RequestBody Genre requestBody) {
        return genreService.saveGenre(requestBody);
    }

    @GetMapping("/getAll")
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @PutMapping("/update")
    public Genre update(@RequestBody Genre requestBody) throws NotFoundException {
        return genreService.updateGenre(requestBody);
    }

    @DeleteMapping()
    public void delete(@RequestParam("id") Integer id) {
        genreService.deleteGenre(id);
    }
}
