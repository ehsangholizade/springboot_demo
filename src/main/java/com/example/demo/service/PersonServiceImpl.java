package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        Person updateperson = personRepository.findById(person.getId())
                .orElseThrow(() -> new RuntimeException("not found person"));

        updateperson.setName(person.getName());
        updateperson.setPhoneNumber(person.getPhoneNumber());
        return personRepository.save(updateperson);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("not found person with :" + id));
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    @Override
    public void delete(Long id){
        personRepository.deleteById(id);
    }

    public Optional<Person> findByNameAndPhoneNumber(String name, String phoneNumber){
        return Optional.ofNullable(personRepository.findByNameAndPhoneNumber(name, phoneNumber)
                .orElseThrow(() -> new RuntimeException("person not found")));
    }
    public Person findByCreationDate(){
        Sort sort = Sort.by(Sort.Order.desc("creationDate"));
       return personRepository.findTopByCreationDateIsNotNull(sort).orElseThrow(()->new RuntimeException("person not found"));
    }

}
