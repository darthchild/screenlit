package com.ekagra.screenlit.services;

import com.ekagra.screenlit.entities.Movie;
import com.ekagra.screenlit.entities.Review;
import com.ekagra.screenlit.repositories.MovieRepository;
import jakarta.persistence.Table;
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


    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public List<Review> allReviewsOfMovie(String imdbId){

        Optional<Movie> movieOptional = movieRepository.findMovieByImdbId(imdbId);

        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            return movie.getReviews();
        } else {
            throw new RuntimeException("Movie not found with imdb_id: " + imdbId);
        }
    }
}
