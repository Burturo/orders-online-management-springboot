package com.example.order_online_api.service;

import com.example.order_online_api.dto.LoginDTO;
import com.example.order_online_api.dto.RegisterDTO;
import com.example.order_online_api.entity.User;
import com.example.order_online_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setFirstname(registerDTO.getFirstname());
        user.setLastname(registerDTO.getLastname());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());  // Pense à hasher le mot de passe ici

        return userRepository.save(user);
    }

    public User loginUser(LoginDTO loginDTO) {
        User foundUser = userRepository.findByEmail(loginDTO.getEmail());
        if (foundUser != null && foundUser.getPassword().equals(loginDTO.getPassword())) {
            return foundUser;
        }
        return null; // Ou lancer une exception personnalisée
    }
}
