package com.example.movieapp.repository;

import com.example.movieapp.model.ContentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentCommentRepository extends JpaRepository<ContentComment,Integer>{
    List<ContentComment> getByReplayToComment(ContentComment contentComment);
}
