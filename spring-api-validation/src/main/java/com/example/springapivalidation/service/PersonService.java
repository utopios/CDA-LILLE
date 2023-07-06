package com.example.springapivalidation.service;

import com.example.springapivalidation.entity.Person;
import com.example.springapivalidation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    @Autowired
    private PersonRepository personRepository;


    public void save(Person person){
        personRepository.save(person);
    }



}
