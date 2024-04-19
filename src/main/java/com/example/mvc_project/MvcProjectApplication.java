package com.example.mvc_project;

import com.example.mvc_project.model.User;
import com.example.mvc_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcProjectApplication.class, args);
	}

}

