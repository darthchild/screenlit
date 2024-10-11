import './Hero.css';
import Carousel from 'react-material-ui-carousel';
import { Paper } from '@mui/material';
import { Link, useNavigate } from 'react-router-dom';
import PlayButton from '../buttons/PlayButton';
import SeeReviewsButton from '../buttons/SeeReviewsButton'

const Hero = ({movies}) => {
    return (
        <div className='movie-carousel-container'>
            <Carousel>
                {
                    movies?.map((movie) =>{
                        const navigate = useNavigate();
                        const trailerLink = movie.trailerLink;
                        
                        function reviews(movieId){
                            navigate(`/reviews/${movieId}`);
                        }
                        return (
                            <Paper key={movie.imdbId}>
                                <div className='movie-card-container'>
                                    <div className="movie-card" style={{
                                        "--img": `url(${movie.backdrop})`
                                    }}>
                                        <div className="movie-detail">
                                            <div className="movie-poster">
                                                <img src={movie.poster} alt={movie.title} />
                                            </div>
                                            <div className="movie-info">
                                                <div className="movie-title">
                                                    <h2>{movie.title}</h2>
                                                </div>
                                                <div className="movie-buttons">
                                                    <Link to={`/trailer/${trailerLink.substring(trailerLink.length-11)}`} style={{ textDecoration: 'none' }}>
                                                        <PlayButton className="play-button"> Play Trailer</PlayButton>
                                                    </Link>
                                                    <SeeReviewsButton onClick={() => reviews(movie.imdbId)}>See Reviews</SeeReviewsButton>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </Paper>
                        )
                    })
                }
            </Carousel>
        </div>
    );
};

export default Hero;