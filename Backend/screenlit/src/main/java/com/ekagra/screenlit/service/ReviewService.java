package com.ekagra.screenlit.service;

import com.ekagra.screenlit.exception.ResourceNotFoundException;
import com.ekagra.screenlit.exception.ReviewSaveException;
import com.ekagra.screenlit.model.Movie;
import com.ekagra.screenlit.repository.MovieRepository;
import com.ekagra.screenlit.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ekagra.screenlit.model.Review;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    @Transactional
    public Review createReview(String imdbId, String reviewBody, Double rating) {

        if (rating == null || rating < 0 || rating > 10) {
            throw new ReviewSaveException("Rating must be between 0 and 10");
        }
        if (reviewBody == null || reviewBody.isBlank()) {
            throw new ReviewSaveException("Review body cannot be empty");
        }

        Movie movie = movieRepository.findMovieByImdbId(imdbId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Movie not found with imdb_id: " + imdbId)
                );

        // creating the review object
        Review review = Review.builder()
                .body(reviewBody)
                .rating(rating)
                .movie(movie)
                .build();

        try {
            Review savedReview = reviewRepository.save(review);
            // Update the movie's reviews list (bidirectional relationship)
            movie.getReviews().add(savedReview);
            movieRepository.save(movie);
            return savedReview;
        } catch (DataAccessException ex) {
            throw new ReviewSaveException("Failed to save review due to database constraint", ex);
        }
    }
}

