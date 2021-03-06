package com.example.movieapp.repository;
import com.example.movieapp.model.Episode;
import com.example.movieapp.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    void deleteBySeason(Season season);
}
