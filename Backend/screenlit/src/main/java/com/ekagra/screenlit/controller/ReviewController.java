package com.ekagra.screenlit.controller;

import com.ekagra.screenlit.model.Review;
import com.ekagra.screenlit.model.ReviewRequestDTO;
import com.ekagra.screenlit.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequestDTO reviewRequest){
         Review savedReview = reviewService.createReview(
                reviewRequest.getImdbId(),
                reviewRequest.getReviewBody(),
                reviewRequest.getRating()
         );
         return ResponseEntity.ok(savedReview);
    }
}
