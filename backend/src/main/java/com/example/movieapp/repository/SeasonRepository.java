package com.example.movieapp.repository;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
    List<Season> findByContent(Content content);
}
