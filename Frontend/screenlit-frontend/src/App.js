import "./App.css";
import api from "./api/axiosConfig";
import { useState, useEffect } from "react";
import Layout from './components/Layout'
import { Routes, Route } from 'react-router-dom';
import Home from './components/home/Home';
import Header from './components/header/Header';
import Trailer from './components/trailer/Trailer';
import Reviews from "./components/reviews/Reviews";
import NotFound from './components/notFound/NotFound';
import Future from './components/future/Future'

function App() {

	const [movies, setMovies] = useState();
	const [movie, setMovie] = useState();
	const [reviews, setReviews] = useState([]);
	const [rating, setRating] = useState('');

    // GET request for all movies (array of all movie's data)
	const getMovies = async () => {
		try
		{
			const response = await api.get("/api/v1/movies");
			//console.log(response.data);
			setMovies(response.data);
		} 
		catch (err) 
		{
			console.log(err);
		}
	};

	// GET request for a single movie acc to imdbId
	const getMovieData = async (movieId) => {
		
		try 
		{
			const response = await api.get(`/api/v1/movies/${movieId}`);
			const singleMovie = response.data;
			console.log(singleMovie);
			// setting state for the "movie" var
			setMovie(singleMovie);
			// extracting reviews array from movie data and track its state
			setReviews(singleMovie.reviews);

		}
		catch (error) 
		{
			console.error(error);
		}
	}

	useEffect(() => {
		getMovies();
	},[])

	return (
		<div className="App">
			<Header/>
			<Routes>
				<Route path="/" element={<Layout/>}>

					<Route path="/" 
						element={<Home movies = {movies}/>} /> 
					
					<Route path="/trailer/:ytTrailerId" 
						element={<Trailer/>} /> 

					<Route path="/reviews/:movieId" 
						element = {<Reviews 
							getMovieData = {getMovieData}
							movie = {movie}
							reviews = {reviews}
							setReviews = {setReviews}
							rating={rating}
							setRating={setRating} /> } />

					<Route path="*" 
						element={<NotFound/>} /> 

					{/* Wildcard Route for Under Development */}
					<Route path="/watchlist" 
						element={<Future />} />

					<Route path="/myProfile" 
						element={<Future />} />

				</Route>
			</Routes>
		</div>

	);
}

export default App;