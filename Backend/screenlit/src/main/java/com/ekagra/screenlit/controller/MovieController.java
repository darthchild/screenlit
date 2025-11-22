package com.ekagra.screenlit.controller;

import com.ekagra.screenlit.model.Movie;
import com.ekagra.screenlit.model.Review;
import com.ekagra.screenlit.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {


    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/allReviews/{imdbId}")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.allReviewsOfMovie(imdbId), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

    @GetMapping("/admin")
    public String adminTest(){
        return "Success";
    }
}
