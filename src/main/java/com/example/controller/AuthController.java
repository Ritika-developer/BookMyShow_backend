//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.User;
//import com.example.service.UserService;
//
//
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public User register(@RequestBody User user) {
//        return userService.registerUser(user);
//    }
//
//}








//
//
//
//package com.example.controller;
//
//import com.example.model.User;
//import com.example.service.UserService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//public class AuthController {
//
//    private final UserService userService;
//
//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public List<User> getAll() {
//        return userService.getAll();
//    }
//}






package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService service;
    
    @PostMapping("/register")
    public Object register(@RequestBody User user) {
        try {
            user.setRole("USER");
            return service.register(user);
        } catch (RuntimeException e) {
            return Map.of("error", "Email already registered");
        }
    }

    @PostMapping("/login")
    public Object login(@RequestBody Map<String, String> data) {
        try {
            return service.login(data.get("email"), data.get("password"));
        } catch (RuntimeException e) {
            if (e.getMessage().equals("USER_NOT_FOUND")) {
                return Map.of("error", "User not registered");
            } else if (e.getMessage().equals("INVALID_PASSWORD")) {
                return Map.of("error", "Wrong password");
            }
            return Map.of("error", "Login failed");
        }
    }
    
    
}




