package com.example.learn.service;


import com.example.learn.model.Book;
import com.example.learn.model.Review;
import com.example.learn.repo.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviewsByBook(Book book) {
        return reviewRepository.findByBook(book);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
}
