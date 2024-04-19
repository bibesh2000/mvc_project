package com.example.mvc_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="USerDetails")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "Name")
        private String name;

        @Column(name = "Phone_Number")
        private Integer phoneNumber;

        @Column(name = "Age")
        private Integer age;

        @Column(name = "Address")
        private String address;

        @Column(name = "Email_Address")
        private String emailAddress;

        @Column(name = "Status")
        private Boolean status;
}
