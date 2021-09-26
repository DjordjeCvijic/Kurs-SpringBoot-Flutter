package com.example.movieapp.repository;
import com.example.movieapp.model.ContentType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentTypeRepository extends JpaRepository<ContentType, Integer> {
}
