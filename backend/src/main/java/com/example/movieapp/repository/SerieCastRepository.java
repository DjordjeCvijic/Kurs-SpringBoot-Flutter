package com.example.movieapp.repository;

import com.example.movieapp.compositekey.SerieCastKey;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.Season;
import com.example.movieapp.model.SerieCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieCastRepository extends JpaRepository<SerieCast, SerieCastKey> {
    void deleteBySeason(Season season);
}
