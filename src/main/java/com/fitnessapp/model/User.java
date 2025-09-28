package com.fitnessapp.model;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    // GeneratedValue - Tells JPA this field(id) should be automatically generated
    // GenerationType.IDENTITY - DB auto-increments (like serial) starts from 1
    // Strategy = instruction to JPA (tells how to generate the primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA action
    private Long id; // only for db

    @Column(nullable = false) // DB will reject inserts without a value
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true) // cannot have same email as other rows
    private String email;

    // bidirectional One user can have many routines
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Routine> routines = new ArrayList<>();
    /*
     * From a Routine -> get the owning User
     * From a user -> get all Routines
     */

    public User() {

    }

    // id not needed to be created due to GeneratedValue
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 2. Tokens that allows to be authenticated to allow access to end point
    // 3. JWT and attach to POSTMAN JWT or CSRF
    // 4. Middleware(authenticato) = interceptor

    // user with email and password --> test authentication
    // after register /
    // save token on cookies or local storage save them on backend ?
    // not permanent token or until it expires 7 days **refresh token**
    // register endpoint

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

}
