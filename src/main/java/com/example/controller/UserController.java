package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;

    // ✅ Constructor Injection
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔹 UPDATE USER (PROFILE)
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {

        User existing = userRepository.findById(id).orElseThrow();

        existing.setName(user.getName());
        existing.setPhone(user.getPhone());

        return userRepository.save(existing);
    }
}