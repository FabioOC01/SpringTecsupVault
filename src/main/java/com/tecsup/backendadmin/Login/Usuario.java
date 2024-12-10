package com.tecsup.backendadmin.Login;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column
    private String role;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)  // email no debe ser nulo y único
    private String email;  // Añadido el campo de email

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;  // Getter para email
    }

    public void setEmail(String email) {
        this.email = email;  // Setter para email
    }
}
