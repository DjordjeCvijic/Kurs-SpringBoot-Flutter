package com.example.movieapp.service;

import com.example.movieapp.model.Genre;
import com.example.movieapp.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    public Genre saveGenre(@RequestBody Genre requestBody) {
        System.out.println(requestBody.getGenreId());
        return genreRepository.save(requestBody);
    }

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Genre updateGenre(Genre item) {
        Genre genre=genreRepository.findById(item.getGenreId()).get();
        genre.setName(item.getName());
        genreRepository.save(genre);
        return genre;
    }

    public void deleteGenre(Integer genreId) {
        genreRepository.deleteById(genreId);
    }
}
