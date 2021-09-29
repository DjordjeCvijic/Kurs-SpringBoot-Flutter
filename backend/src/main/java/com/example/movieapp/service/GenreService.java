package com.example.movieapp.service;

import com.example.movieapp.model.Country;
import com.example.movieapp.model.Genre;
import com.example.movieapp.repository.GenreRepository;
import javassist.NotFoundException;
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

    public Genre updateGenre(Genre item) throws NotFoundException {
        Genre genre=getGenreById(item.getGenreId());
        genre.setName(item.getName());
        genreRepository.save(genre);
        return genre;
    }

    public Genre getGenreById(Integer id) throws NotFoundException {
        return genreRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađen zanr sa id-em:" + id));
    }

    public void deleteGenre(Integer genreId) {
        genreRepository.deleteById(genreId);
    }
}
