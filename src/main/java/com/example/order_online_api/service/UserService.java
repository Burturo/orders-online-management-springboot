package com.example.order_online_api.service;

import com.example.order_online_api.entity.Contact;
import com.example.order_online_api.entity.Person;
import com.example.order_online_api.entity.User;
import com.example.order_online_api.repository.PersonRepository;
import com.example.order_online_api.repository.ContactRepository;
import com.example.order_online_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String firstname, String lastname, String email, String password) {
        // Vérifier si l'email existe déjà dans la table User
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email is already in use");
        }

        // Créer un Contact avec l'email
        Contact contact = new Contact();
        contact.setEmail(email);
//        contact = contactRepository.save(contact);

        // Créer la Person associée
        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setContact(contact);  // Relier la personne avec le contact


        // Relier l'utilisateur à la personne
//        person.setUser(user);
//        personRepository.save(person);  // Sauvegarder la personne

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));  // Encodage du mot de passe
        user.setPerson(person);  // Relier l'utilisateur à la personne
        user = userRepository.save(user);

        return user;
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }
}
