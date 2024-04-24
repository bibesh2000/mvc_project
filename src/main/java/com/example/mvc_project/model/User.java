package com.example.mvc_project.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name="user_details")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "phone_number")
        private Integer phoneNumber;

        @Column(name = "age")
        private Integer age;

        @Column(name = "address")
        private String address;

        @Column(name = "email_address")
        private String emailAddress;

        @Column(name = "status")
        private Boolean status;
}
