package com.snehansh.SpringRestAPI.service;

import com.snehansh.SpringRestAPI.entity.Person;
import com.snehansh.SpringRestAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository userRepository;
    @Override
    public Person saveUser(Person person) {
        return userRepository.save(person);
    }
}
