package com.example.movieapp.service;

import com.example.movieapp.compositekey.ReviewKey;
import com.example.movieapp.dto.ReviewDto;
import com.example.movieapp.model.*;
import com.example.movieapp.repository.ReviewRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserPersonService userPersonService;
    @Autowired
    ContentService contentService;

    public Review saveReview(ReviewDto reviewDto) throws NotFoundException {
        Review review = reviewRepository.save(buildReviewFromDto(reviewDto));
        updateRating(review.getContent());
        return review;
    }
    public void deleteReviewByContent(Content content){
        reviewRepository.deleteByContent(content);
    }
    public void deleteReviewById(int userId,int contentId) throws NotFoundException {
        reviewRepository.deleteById(new ReviewKey(userId,contentId));
        updateRating(contentService.getContentById(contentId));
    }

    public Review getReviewById(int userId,int contentId) {//moze biti da ga nema
        return reviewRepository.findById(new ReviewKey(userId,contentId)).get();
    }

    private void updateRating(Content content) {
        List<Review> reviewsForThisContent=reviewRepository.findByContent(content);
        double allRating= reviewsForThisContent.stream().mapToDouble(Review::getRating).sum();
        content.setRating((float) (allRating/reviewsForThisContent.size()));
        contentService.updateRating(content);
    }

    private Review buildReviewFromDto(ReviewDto reviewDto) throws NotFoundException {
        ReviewKey reviewKey = new ReviewKey(reviewDto.getUserPersonId(), reviewDto.getContentId());
        UserPerson userPerson = userPersonService.getUserPersonById(reviewDto.getUserPersonId());
        Content content = contentService.getContentById(reviewDto.getContentId());
        return new Review(reviewKey, userPerson, content, reviewDto.getRating(), reviewDto.getFavorite());
    }
    public Review updateReview(ReviewDto reviewDto) throws NotFoundException {//exception
        return saveReview(reviewDto);
    }
    public List<Review>getAll(){
        return reviewRepository.findAll();
    }
}
