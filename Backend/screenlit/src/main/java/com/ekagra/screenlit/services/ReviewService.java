package com.ekagra.screenlit.services;

import com.ekagra.screenlit.entities.Movie;
import com.ekagra.screenlit.exceptions.ErrorResponse;
import com.ekagra.screenlit.repositories.MovieRepository;
import com.ekagra.screenlit.repositories.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ekagra.screenlit.entities.Review;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    public ResponseEntity<?> createReview(String imdbId, String reviewBody, Double rating) {
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

            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        } else {

            ErrorResponse errorResponse = new ErrorResponse(
                    "Movie not found with imdb_id: " + imdbId,
                    HttpStatus.NOT_FOUND.value()
            );

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }


}

