package com.example.mvc_project.controller;

import com.example.mvc_project.model.User;
import com.example.mvc_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully");
    }

    @GetMapping("/view-all-users")
    public List<User> getALlUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<?> viewUser(@PathVariable Long userId) {
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            return  ResponseEntity.ok(userOptional.get());
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid User Id");
        }

    }



    @DeleteMapping("/remove/{userId}")
    public ResponseEntity<String> removeUser(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        if(user.isPresent()){
            userService.deleteUser(userId);
            return ResponseEntity.ok("User deleted successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid User Id");
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody User updateUser) {

        User updatedUser = userService.updateUser(userId, updateUser);
        if (updatedUser != null) {
            return ResponseEntity.ok("User details updated");
        } else {
            return ResponseEntity.badRequest().body("Invalid user");
        }
    }

}