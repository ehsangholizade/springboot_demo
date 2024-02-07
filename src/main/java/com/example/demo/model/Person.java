package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Person extends BaseEntity{

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phoneNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
