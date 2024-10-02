package com.example.order_online_api.controller;

import com.example.order_online_api.dto.LoginDTO;
import com.example.order_online_api.dto.RegisterDTO;
import com.example.order_online_api.entity.User;
import com.example.order_online_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@Validated @RequestBody RegisterDTO registerDTO) {
        return userService.registerUser(registerDTO);
    }

    @PostMapping("/login")
    public User loginUser(@Validated @RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }
}
