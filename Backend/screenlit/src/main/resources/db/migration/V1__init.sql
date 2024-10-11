-- V1__init.sql for creating migrations

-- Create Movie table
CREATE TABLE movie (
    id BIGSERIAL PRIMARY KEY,
    imdb_id VARCHAR(255),
    title VARCHAR(255),
    release_date VARCHAR(255),
    trailer_link VARCHAR(255),
    poster VARCHAR(255),
    backdrop VARCHAR(255)
);

-- Create Review table
CREATE TABLE review (
    id BIGSERIAL PRIMARY KEY,
    body TEXT,
    movie_id BIGINT,
    FOREIGN KEY (movie_id) REFERENCES movie(id)
);

-- Create Genre table
CREATE TABLE genre (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

-- Create join table for Movie and Genre (many-to-many relationship)
CREATE TABLE movie_genres (
    movie_id BIGINT,
    genre_id BIGINT,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES movie(id),
    FOREIGN KEY (genre_id) REFERENCES genre(id)
);