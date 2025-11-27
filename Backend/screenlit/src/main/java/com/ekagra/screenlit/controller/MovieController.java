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
        return ResponseEntity.ok(movieService.allMovies());
    }

    @GetMapping("/allReviews/{imdbId}")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable String imdbId){
        return ResponseEntity.ok(movieService.allReviewsOfMovie(imdbId));
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getSingleMovie(@PathVariable String imdbId){
        return ResponseEntity.ok(movieService.singleMovie(imdbId));
    }

    @GetMapping("/admin")
    public String adminTest(){
        return "Success";
    }
}
