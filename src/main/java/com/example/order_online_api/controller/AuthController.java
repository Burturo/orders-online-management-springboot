package com.example.order_online_api.controller;

import com.example.order_online_api.dto.RegisterDTO;
import com.example.order_online_api.dto.LoginDTO;
import com.example.order_online_api.entity.Person;
import com.example.order_online_api.entity.User;
import com.example.order_online_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:8080")  // Autorise les requêtes CORS depuis le frontend Vue.js
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
        try {
            User newUser = userService.registerUser(
                    registerDTO.getFirstname(),
                    registerDTO.getLastname(),
                    registerDTO.getEmail(),
                    registerDTO.getPassword()
            );
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        try {
            User user = userService.loginUser(loginDTO.getEmail(), loginDTO.getPassword());
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}