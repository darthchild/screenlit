import './Header.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStamp } from "@fortawesome/free-solid-svg-icons";
import { Button, Container, Nav, Navbar } from "react-bootstrap";
import { NavLink } from "react-router-dom";

const Header = () => {
 
return (
    <Navbar bg="dark" variant="dark" expand="lg" style={{ paddingTop: '10px' }}>
    <Container fluid>
        <Navbar.Brand href="/" style={{ color: 'gold' }}>
        <FontAwesomeIcon icon={faStamp} />  the screenlit reviews &#47;
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
        <Nav
            className="navbar-nav my-2 my-lg-0"
            style={{ maxHeight: '100px' }}
            navbarScroll
        >
            <NavLink className="nav-link" to="/">Home</NavLink>
            <NavLink className="nav-link" to="/watchList">Watch List</NavLink>
            <NavLink className="nav-link" to="/myProfile">My Profile</NavLink>
        </Nav>
        <Button className="me-2 login" style={{ backgroundColor: '#8e7900', borderColor: '#8e7900' }}>Login</Button>
        <Button className="register">Register</Button>
        </Navbar.Collapse>
    </Container>
    </Navbar>
  )
}

export default Header