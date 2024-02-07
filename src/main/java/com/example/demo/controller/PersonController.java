package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/demo")
@RestController
public class PersonController {

    final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.ok(personService.save(person));
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) {
        return ResponseEntity.ok(personService.update(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}/{phoneNumber}")
    public ResponseEntity<Optional<Person>> findByNameAndPhoneNumber(@PathVariable String name, @PathVariable String phoneNumber) {
        return ResponseEntity.ok(personService.findByNameAndPhoneNumber(name, phoneNumber));
    }
    @GetMapping("/findByCreationDate")
    public ResponseEntity<Person> findByCreationDate(){
        return ResponseEntity.ok(personService.findByCreationDate());
    }

}
