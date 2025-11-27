package com.ekagra.screenlit.service;

import com.ekagra.screenlit.exception.ResourceNotFoundException;
import com.ekagra.screenlit.model.Movie;
import com.ekagra.screenlit.exception.ErrorResponse;
import com.ekagra.screenlit.repository.MovieRepository;
import com.ekagra.screenlit.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ekagra.screenlit.model.Review;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    public Review createReview(String imdbId, String reviewBody, Double rating) {
        Optional<Movie> movieOptional = movieRepository.findMovieByImdbId(imdbId);

        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();

            // creating the review object
            Review review = Review.builder()
                    .body(reviewBody)
                    .rating(rating)
                    .movie(movie)
                    .build();
            Review savedReview = reviewRepository.save(review);

            // Update the movie's reviews list (bi-directional relationship)
            movie.getReviews().add(savedReview);
            movieRepository.save(movie);

            return savedReview;
        } else {
            throw new ResourceNotFoundException("Movie not found with imdb_id: " + imdbId);
        }
    }


}

