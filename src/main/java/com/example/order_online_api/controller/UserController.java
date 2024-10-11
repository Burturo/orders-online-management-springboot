package com.example.order_online_api.controller;

import com.example.order_online_api.dto.LoginDTO;
import com.example.order_online_api.dto.RegisterDTO;
import com.example.order_online_api.entity.User;
import com.example.order_online_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Validated @RequestBody RegisterDTO registerDTO) {
        User registeredUser = userService.registerUser(registerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@Validated @RequestBody LoginDTO loginDTO) {
        User loggedInUser = userService.loginUser(loginDTO);
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Ou lancer une exception personnalisée
    }
}
