import '../reviewForm/ReviewForm.css';
import {useEffect, useRef, useState} from 'react';
import api from '../../api/axiosConfig';
import {useParams} from 'react-router-dom';
import {Container, Form, Row, Col} from 'react-bootstrap';
import ReviewForm from '../reviewForm/ReviewForm';
import React from 'react';

const Reviews = ({getMovieData, movie, reviews, setReviews}) => {
    const revText = useRef();
    const [rating, setRating] = useState('');
    let params = useParams();
    const movieId = params.movieId;

    useEffect(() => {
        getMovieData(movieId);
    }, []);

    const addReview = async (e) => {
        e.preventDefault();
        const rev = revText.current;

        try {
            const response = await api.post("/api/v1/reviews", {
                reviewBody: rev.value,
                imdbId: movieId,
                rating: rating
            });

            const updatedReviews = [...(reviews || []), { body: rev.value, rating: rating }];

            rev.value = "";
            setRating('');
            setReviews(updatedReviews);
        } catch(err) {
            console.error(err);
        }
    }

    return (
        <Container>
            <Row>
                <Col><h3 style={{marginTop: '20px'}}><p>the reviews / </p></h3></Col>
            </Row>
            <Row className="mt-2">
                <Col>
                    <img src={movie?.poster} alt="" />
                </Col>
                <Col>
                    <>
                        <Row>
                            <Col>
                                <h2>Submit Your Review</h2>
                                <br/>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <Form.Group className="d-flex align-items-center">
                                    <Form.Label className="me-2" style={{marginTop: '15px'}}><h5>Your Rating </h5></Form.Label>
                                    <Form.Control 
                                        type="number" 
                                        min="1" 
                                        max="10" 
                                        placeholder="9?"
                                        className="custom-placeholder" 
                                        value={rating}
                                        onChange={(e) => setRating(e.target.value)}
                                        style={{ 
                                            borderRadius: '10px', 
                                            width: '70px',
                                            color: '#fff',
                                            backgroundColor: '#000',
                                            borderColor: '#d1be0a'
                                        }} 
                                    />
                                </Form.Group>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <ReviewForm handleSubmit={addReview} revText={revText} />
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <hr />
                            </Col>
                        </Row>
                    </>
                    {reviews?.map((r) => (
                        <React.Fragment key={r.id}>
                            <Row>
                                <Col xs={2} style={{ color: '#ccccc2' }}>⭐{r.rating || 'N/A'}</Col>
                                <Col xs={10}>{r.body}</Col>
                            </Row>
                            <Row>
                                <Col>
                                    <hr />
                                </Col>
                            </Row>                                
                        </React.Fragment>
                    ))}
                </Col>
            </Row>
            <Row>
                <Col>
                    <hr />
                </Col>
            </Row>        
        </Container>
    );
}

export default Reviews;