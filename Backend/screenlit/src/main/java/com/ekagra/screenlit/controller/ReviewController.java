package com.ekagra.screenlit.controller;

import com.ekagra.screenlit.model.Review;
import com.ekagra.screenlit.model.ReviewRequestDto;
import com.ekagra.screenlit.service.ReviewService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Review> createReview(@Valid @RequestBody ReviewRequestDto reviewRequest){
         Review savedReview = reviewService.createReview(
                reviewRequest.imdbId(),
                reviewRequest.reviewBody(),
                reviewRequest.rating()
         );
        return ResponseEntity.ok(savedReview);
    }
}
