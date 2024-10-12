package com.example.order_online_api.repository;

import com.example.order_online_api.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
//    Person findByContact_Email(String email);
}
