package com.example.movieapp.service;


import com.example.movieapp.model.ContentGenre;
import com.example.movieapp.model.Genre;
import com.example.movieapp.repository.ContentGenreRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContentGenreService {

    @Autowired
    ContentGenreRepository contentGenreRepository;

    public ContentGenre saveContentGenre(@RequestBody ContentGenre requestBody) {
        return contentGenreRepository.save(requestBody);
    }

    public List<ContentGenre> getAll() {
        return contentGenreRepository.findAll();
    }

    public void deleteContentGenreByContentID(Integer contentId) {

        contentGenreRepository.deleteAllByContentGenreKeyContentId(contentId);
    }
}
