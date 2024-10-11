package com.ekagra.screenlit.repositories;

import com.ekagra.screenlit.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // automatically gen query  - formed dynamically through property names
    public Optional<Movie> findMovieByImdbId(String imdbId);
}
