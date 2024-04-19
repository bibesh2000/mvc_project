package com.example.mvc_project.repository;

import com.example.mvc_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

}