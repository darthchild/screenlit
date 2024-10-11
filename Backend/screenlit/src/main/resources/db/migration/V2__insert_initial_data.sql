-- V1__insert_inital_data.sql for populating initial data into the tables

-- Insert Genres
INSERT INTO genre (name) VALUES
('Animation'), ('Action'), ('Comedy'), ('Family'),
('Science Fiction'), ('Adventure'), ('Horror'),
('Fantasy'), ('Drama'), ('History');

-- Insert Movies and associate with Genres
INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt3915174', 'Puss in Boots: The Last Wish', '2022-12-21', 'https://www.youtube.com/watch?v=tHb7WlgyaUc', 'https://image.tmdb.org/t/p/w500/1NqwE6LP9IEdOZ57NCT51ftHtWT.jpg', 'https://image.tmdb.org/t/p/original/r9PkFnRUIthgBp2JZZzD380MWZy.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt3915174' AND g.name IN ('Animation', 'Action', 'Comedy', 'Family');

INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt1630029', 'Avatar: The Way of Water', '2022-12-16', 'https://www.youtube.com/watch?v=d9MyW72ELq0', 'https://image.tmdb.org/t/p/w500/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg', 'https://image.tmdb.org/t/p/original/s16H6tpK2utvwDtzZ8Qy4qm5Emw.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt1630029' AND g.name IN ('Science Fiction', 'Action', 'Adventure');

INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt8760708', 'M3GAN', '2023-01-06', 'https://www.youtube.com/watch?v=BRb4U99OU80', 'https://image.tmdb.org/t/p/w500/xBl5AGw7HXZcv1nNXPlzGgO4Cfo.jpg', 'https://image.tmdb.org/t/p/original/5kAGbi9MFAobQTVfK4kWPnIfnP0.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt8760708' AND g.name IN ('Science Fiction', 'Horror', 'Comedy');

INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt11116912', 'Troll', '2022-12-01', 'https://www.youtube.com/watch?v=AiohkY_XQYQ', 'https://image.tmdb.org/t/p/w500/9z4jRr43JdtU66P0iy8h18OyLql.jpg', 'https://image.tmdb.org/t/p/original/53BC9F2tpZnsGno2cLhzvGprDYS.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt11116912' AND g.name IN ('Fantasy', 'Action', 'Adventure');

INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt6443346', 'Black Adam', '2022-10-19', 'https://www.youtube.com/watch?v=JaV7mmc9HGw', 'https://image.tmdb.org/t/p/w500/pFlaoHTZeyNkG83vxsAJiGzfSsa.jpg', 'https://image.tmdb.org/t/p/original/bQXAqRx2Fgc46uCVWgoPz5L5Dtr.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt6443346' AND g.name IN ('Fantasy', 'Action', 'Science Fiction');

INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt0499549', 'Avatar', '2009-12-15', 'https://www.youtube.com/watch?v=5PSNL1qE6VY', 'https://image.tmdb.org/t/p/w500/jRXYjXNq0Cs2TcJjLkki24MLp7u.jpg', 'https://image.tmdb.org/t/p/original/o0s4XsEDfDlvit5pDRKjzXR4pp2.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt0499549' AND g.name IN ('Fantasy', 'Action', 'Science Fiction', 'Adventure');

INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt3447590', 'Roald Dahl''s Matilda the Musical', '2022-11-25', 'https://www.youtube.com/watch?v=lroAhsDr2vI', 'https://image.tmdb.org/t/p/w500/ga8R3OiOMMgSvZ4cOj8x7prUNYZ.jpg', 'https://image.tmdb.org/t/p/original/nWs0auTqn2UaFGfTKtUE5tlTeBu.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt3447590' AND g.name IN ('Fantasy', 'Family', 'Comedy');

INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt9114286', 'Black Panther: Wakanda Forever', '2022-11-11', 'https://www.youtube.com/watch?v=_Z3QKkl1WyM', 'https://image.tmdb.org/t/p/w500/cryEN3sWlgB2wTzcUNVtDGI8bkM.jpg', 'https://image.tmdb.org/t/p/original/yYrvN5WFeGYjJnRzhY0QXuo4Isw.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt9114286' AND g.name IN ('Action', 'Adventure', 'Science Fiction');

INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt10298840', 'Strange World', '2022-11-23', 'https://www.youtube.com/watch?v=bKh2G73gCCs', 'https://image.tmdb.org/t/p/w500/kgJ8bX3zDQDM2Idkleis28XSVnu.jpg', 'https://image.tmdb.org/t/p/original/5wDBVictj4wUYZ31gR5WzCM9dLD.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt10298840' AND g.name IN ('Family', 'Adventure', 'Science Fiction', 'Animation');

INSERT INTO movie (id, imdb_id, title, release_date, trailer_link, poster, backdrop)
VALUES
(DEFAULT, 'tt8093700', 'The Woman King', '2022-09-15', 'https://www.youtube.com/watch?v=3RDaPV_rJ1Y', 'https://image.tmdb.org/t/p/w500/5O1GLla5vNuegqNxNhKL1OKE1lO.jpg', 'https://image.tmdb.org/t/p/original/gkseI3CUfQtMKX41XD4AxDzhQb7.jpg');

INSERT INTO movie_genres (movie_id, genre_id)
SELECT m.id, g.id
FROM movie m, genre g
WHERE m.imdb_id = 'tt8093700' AND g.name IN ('Action', 'Drama', 'History');
