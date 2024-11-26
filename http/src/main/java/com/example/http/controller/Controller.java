package com.example.http.controller;

import com.example.http.model.UserEntity;
import com.example.http.service.ServiceBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users") // Base URL for this controller
public class Controller {

    @Autowired
    private ServiceBus serviceBus; // Service layer for business logic

    // Create a new user
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(serviceBus.SaveUserEntity(user)); // Directly return the response
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(serviceBus.getAllUserEntity()); // Directly return the list of users
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id) {
        Optional<UserEntity> user = serviceBus.getUserEntityById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a user
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable int id, @RequestBody UserEntity userDetails) {
        UserEntity updatedUser = serviceBus.updateUserEntity(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        return serviceBus.deleteUserEntity(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
