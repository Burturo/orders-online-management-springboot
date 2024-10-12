package com.example.order_online_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.order_online_api.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
