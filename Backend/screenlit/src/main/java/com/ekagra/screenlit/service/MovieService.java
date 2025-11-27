package com.ekagra.screenlit.service;

import com.ekagra.screenlit.exception.ResourceNotFoundException;
import com.ekagra.screenlit.model.Movie;
import com.ekagra.screenlit.model.Review;
import com.ekagra.screenlit.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Movie singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Movie not found with imdb_id: " + imdbId));
    }

    public List<Review> allReviewsOfMovie(String imdbId){
        Movie movie = movieRepository.findMovieByImdbId(imdbId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Movie not found with imdb_id: " + imdbId));
        return movie.getReviews();
    }
}
