package com.ekagra.screenlit;

import com.ekagra.screenlit.entities.Genre;
import com.ekagra.screenlit.entities.Movie;
import com.ekagra.screenlit.entities.Review;
import com.ekagra.screenlit.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void saveMovie(){

        Movie movie = Movie.builder()
                .title("La La Land")
                .imdbId("im297371")
                .build();

        Review review1 = Review.builder()
                .body("What a movie!")
                .movie(movie)  // Set movie reference
                .build();

        Review review2 = Review.builder()
                .body("legit masterpiece :)")
                .movie(movie)  // Set movie reference
                .build();

        // Set reviews for the movie
        movie.setReviews(List.of(review1,review2));

        movieRepository.save(movie);
    }

    @Test
    @Transactional
    public void fetchMovieReviews() {

        saveMovie();

        Optional<Movie> fetchedMovie = movieRepository.findById(1L);  // Fetch by movie_id

        if (fetchedMovie.isPresent()) {
            Movie movie = fetchedMovie.get();

            // Accessing reviews will trigger a lazy load
            List<Review> reviews = movie.getReviews();
            reviews.forEach(review -> System.out.println(review.getBody()));
        }
    }

    @Test
    public void testManyToManyRelationship(){
        Genre genre1 = Genre.builder()
                .name("Action")
                .build();

        Genre genre2 = Genre.builder()
                .name("Thriller")
                .build();

        Genre genre3 = Genre.builder()
                .name("Suspense")
                .build();

        Movie movie1 = Movie.builder()
                .title("La La Land")
                .imdbId("im297371")
                .genres(List.of(genre1,genre2,genre3))
                .build();

        Movie movie2 = Movie.builder()
                .title("LA Police")
                .imdbId("im234432")
                .genres(List.of(genre3))
                .build();

        movieRepository.saveAll(List.of(movie1,movie2));
    }


}
