package com.example.mvc_project.service;

import com.example.mvc_project.model.User;
import com.example.mvc_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(Long userId, User userDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setName(userDetails.getName());
            existingUser.setPhoneNumber(userDetails.getPhoneNumber());
            existingUser.setAge(userDetails.getAge());
            existingUser.setAddress(userDetails.getAddress());
            existingUser.setEmailAddress(userDetails.getEmailAddress());
            existingUser.setStatus(userDetails.getStatus());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
