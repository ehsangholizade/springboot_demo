package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByNameAndPhoneNumber(String name, String phoneNumber);

    Optional<Person> findTopByCreationDateIsNotNull(Sort sort);
}
