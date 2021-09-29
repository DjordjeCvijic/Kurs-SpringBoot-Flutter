package com.example.movieapp.repository;

import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentGenre;
import com.example.movieapp.model.ContentGenreKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentGenreRepository extends JpaRepository<ContentGenre, ContentGenreKey> {

    List<ContentGenre> findByContentGenreKeyContentId(int contentId);
    void deleteAllByContentGenreKeyContentId(int contentId);
}
