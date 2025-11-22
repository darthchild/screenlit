package com.ekagra.screenlit.repository;

import com.ekagra.screenlit.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // automatically gen query  - formed dynamically through property names
    public Optional<Movie> findMovieByImdbId(String imdbId);
}
