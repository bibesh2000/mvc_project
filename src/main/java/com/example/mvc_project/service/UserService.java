package com.example.mvc_project.service;

import com.example.mvc_project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

        User addUser(User user);

        List<User> getAllUsers();

        Optional<User> getUserById(Long id);

        User updateUser( Long userId, User userDetails);

        void deleteUser(Long id);
    }


