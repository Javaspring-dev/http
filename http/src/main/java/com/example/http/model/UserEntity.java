package com.example.http.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class UserEntity {
    @Id
    @Column
    private int id;
    @Column
    private String name ;

    public UserEntity(String name, int id) {
        this.name = name;
        this.id = id;
    }

}

