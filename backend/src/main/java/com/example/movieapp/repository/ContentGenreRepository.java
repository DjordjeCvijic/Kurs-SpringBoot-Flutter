package com.example.movieapp.repository;

import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentGenre;
import com.example.movieapp.compositekey.ContentGenreKey;
import com.example.movieapp.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContentGenreRepository extends JpaRepository<ContentGenre, ContentGenreKey> {

    List<ContentGenre> findByContentGenreKeyContentId(int contentId);

    @Modifying
    @Transactional
    void deleteByContent(Content content);

    List<ContentGenre> findByGenre(Genre genre);
}
