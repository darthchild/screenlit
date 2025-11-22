package com.ekagra.screenlit.security;

import com.ekagra.screenlit.security.model.UserDTO;
import com.ekagra.screenlit.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * @return <b>ResponseEntity</b> with Base64Url encoded <b>JWT token string</b>
     * if authenticated, else error message
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO){
        String token = authService.verifyUser(userDTO);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        if(authService.register(userDTO))
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("User created successfully!");
        else return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("User creation failed, check logs");
    }


}
