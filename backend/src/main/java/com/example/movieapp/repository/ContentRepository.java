package com.example.movieapp.repository;


import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentType;
import com.example.movieapp.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Integer> {

    List<Content> findByContentType( ContentType contentType);
}
