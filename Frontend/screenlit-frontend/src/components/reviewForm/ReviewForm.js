import './ReviewForm.css';
import {Form,Button} from 'react-bootstrap';

const ReviewForm = ({handleSubmit,revText,labelText,defaultValue}) => {
    return (

        <Form>
            <Form.Group className="mb-3" controlId="exampleForm.controlTextarea1">

                <Form.Label>{labelText}</Form.Label>

                <Form.Control 
                    ref={revText} 
                    as="textarea" 
                    rows={4} 
                    defaultValue={defaultValue}
                    placeholder = 'Write a Review?'
                    className="custom-placeholder"
                    style={{
                        marginTop: '-20px',
                        color: '#fff',
                        backgroundColor: '#000',
                        borderColor: '#d1be0a', 
                        borderRadius: '10px' 
                    }}
                />

            </Form.Group>
            <Button variant="outline-info" onClick={handleSubmit} style={{marginBottom: '15px'}}> Submit </Button>
        </Form>
    )
}


export default ReviewForm;