package com.example.http.service;

import com.example.http.model.UserEntity;
import com.example.http.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBus {

    @Autowired
    private Repo userRepo; // Use this instance to call the methods




    public List<UserEntity> getAllUserEntity() {
        return userRepo.findAll(); // Use 'userRepo' instead of 'Repo'
    }

    public Optional<UserEntity> getUserEntityById(int id) {
        return userRepo.findById((long) id); // Use 'userRepo' instead of 'Repo'
    }

    public UserEntity SaveUserEntity(UserEntity userEntity) {
        return userRepo.save(userEntity); // Use 'userRepo' instead of 'Repo'
    }

    public boolean deleteUserEntity(int id) {
        if (Repo.existsById(id)) { // Use 'userRepo' instead of 'Repo'
            Repo.deleteById(id); // Use 'userRepo' instead of 'Repo'
            return true;
        }
        return false;
    }

    public UserEntity updateUserEntity(int id, UserEntity userEntity) {
        if (Repo.existsById(id)) { // Use 'userRepo' instead of 'Repo'
            Repo.setId(id);
            return userRepo.save(userEntity); // Use 'userRepo' instead of 'Repo'
        }
        return null;
    }
}
