package com.example.order_online_api.dto;

import com.example.order_online_api.entity.Person;
import com.example.order_online_api.entity.User;

public class UserResponseDTO {
    private User user;
    private Person person;

    public UserResponseDTO(User user, Person person) {
        this.user = user;
        this.person = person;
    }

    // Getters et Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

