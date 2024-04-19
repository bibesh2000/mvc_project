package com.example.mvc_project.controller;

import com.example.mvc_project.model.User;
import com.example.mvc_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add-user")
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "user added successfully";
    }

    @GetMapping("/view-all-users")
    public List<User> getALlUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/user/{userId}")
    public User viewUser(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(null);
    }


    @DeleteMapping("/remove/{userId}")
    public String removeUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
        return "User deleted successfully";
    }

    @PutMapping("/update/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody User updateUser) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User oldUser = optionalUser.get();
            oldUser.setName(updateUser.getName());
            oldUser.setPhoneNumber(updateUser.getPhoneNumber());
            oldUser.setAge(updateUser.getAge());
            oldUser.setAddress(updateUser.getAddress());
            oldUser.setEmailAddress(updateUser.getEmailAddress());
            oldUser.setStatus(updateUser.getStatus());

            userRepository.save(oldUser);
            return "USer deatils Updated";
        } else {
            return "Invalid user";
        }
    }
}