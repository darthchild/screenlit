package com.ekagra.screenlit.controllers;

import com.ekagra.screenlit.dto.ReviewRequestDTO;
import com.ekagra.screenlit.services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody ReviewRequestDTO reviewRequest){
        return reviewService.createReview(
                reviewRequest.getImdbId(),
                reviewRequest.getReviewBody(),
                reviewRequest.getRating()
        );
    }
}
