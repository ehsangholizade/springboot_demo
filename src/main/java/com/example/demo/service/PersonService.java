package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person save(Person person);

    Person update(Person person);

    List<Person> findAll();

    Person findById(Long id);

    void delete(Long id);

    Optional<Person> findByNameAndPhoneNumber(String name, String phoneNumber);
    Person findByCreationDate();
}
