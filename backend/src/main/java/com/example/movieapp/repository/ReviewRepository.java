package com.example.movieapp.repository;

import com.example.movieapp.compositekey.ReviewKey;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, ReviewKey> {
    List<Review> findByContent(Content content);

    void deleteByContent(Content content);
}
