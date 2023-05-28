package com.example.learn.controller;


import com.example.learn.model.Book;
import com.example.learn.model.Review;
import com.example.learn.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/books/{bookId}")
    public List<Review> getReviewsByBook(@PathVariable Long bookId) {
        Book book = new Book();
        book.setId(bookId);
        return reviewService.getReviewsByBook(book);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        // Validate review data
        // Save the review
        Review savedReview = reviewService.saveReview(review);
        return ResponseEntity.ok(savedReview);
    }

    // Other review-related endpoints
}