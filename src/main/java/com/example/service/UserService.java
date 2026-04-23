package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // ✅ Register with duplicate email check
    public User register(User user) {
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("EMAIL_ALREADY_EXISTS");
        }
        return repo.save(user);
    }

    // ✅ Login logic
    public User login(String email, String password) {
        User user = repo.findByEmail(email).orElse(null);

        if (user == null) {
            throw new RuntimeException("USER_NOT_FOUND");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("INVALID_PASSWORD");
        }

        return user;
    }
}