package com.example.http.repository;

import com.example.http.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<UserEntity,Long> {


    static boolean existsById(int id) {
     return false;
    }

    static void deleteById(int id) {
    }

    static void setId(int id) {
    }
}
