package com.mikrofinans.MikroFinans.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan ID

    @NotNull(message = "User name cannot be null")
    @Size(min = 2, max = 50, message = "User name must be between 2 and 50 characters")
    private String name; // Kullanıcı adı

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email; // Kullanıcı e-postası

    private String password;

    private String role;

}