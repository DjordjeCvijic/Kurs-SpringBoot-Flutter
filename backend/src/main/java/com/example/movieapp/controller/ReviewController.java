package com.example.movieapp.controller;

import com.example.movieapp.dto.ContentCommentDto;
import com.example.movieapp.dto.ReviewDto;
import com.example.movieapp.model.ContentComment;
import com.example.movieapp.model.Review;
import com.example.movieapp.service.ContentCommentService;
import com.example.movieapp.service.ReviewService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/getAll")
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping()
    public Review findById(@RequestParam("userId") Integer userId,@RequestParam("contentId") Integer contentId) throws NotFoundException {
        return reviewService.getReviewById(userId,contentId);
    }

    @PostMapping("/save")
    public Review saveContent(@RequestBody ReviewDto requestBody) throws NotFoundException {
        return reviewService.saveReview(requestBody);
    }

    @PutMapping("/update")
    public Review update(@RequestBody ReviewDto requestBody) throws NotFoundException {
        return reviewService.updateReview(requestBody);
    }

    @DeleteMapping()
    public void delete(@RequestParam("userId") Integer userId,@RequestParam("contentId") Integer contentId) throws NotFoundException {
        reviewService.deleteReviewById(userId,contentId);
    }
}
