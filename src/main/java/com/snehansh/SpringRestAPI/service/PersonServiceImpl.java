package com.snehansh.SpringRestAPI.service;

import com.snehansh.SpringRestAPI.entity.Person;
import com.snehansh.SpringRestAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository userRepository;
    @Override
    public Person saveUser(Person person) {
        return userRepository.save(person);
    }

    @Override
    public List<Person> getUser() {
        return userRepository.findAll();
    }

    @Override
    public Person getUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public Person updateUser(Long userId, Person person) {
        Person persondb = userRepository.findById(userId).get();
        if(Objects.nonNull(person.getPersonFirstName()) &&
        !"".equalsIgnoreCase(person.getPersonFirstName())){
            persondb.setPersonFirstName(person.getPersonFirstName());
        }

        if(Objects.nonNull(person.getPersonLastName()) &&
        !"".equalsIgnoreCase(person.getPersonLastName())){
            persondb.setPersonLastName(person.getPersonLastName());
        }
        if(Objects.nonNull(person.getPersonAddress()) &&
        !"".equalsIgnoreCase(person.getPersonAddress())){
            persondb.setPersonAddress(person.getPersonAddress());
        }
        if(Objects.nonNull(person.getPersonEmail()) &&
        !"".equalsIgnoreCase(person.getPersonEmail())){
            persondb.setPersonEmail(person.getPersonEmail());
        }
        if(Objects.nonNull(person.getPersonContact()) &&
        !"".equalsIgnoreCase(person.getPersonContact())){
            persondb.setPersonContact(person.getPersonContact());
        }
        return userRepository.save(persondb);
    }

    @Override
    public String deleteUser(Long userId) {
        Person person = userRepository.findById(userId).get();
        String message;
        if(person.getPersonFirstName().isBlank()){
            message = "Invalid User Id";
        }else{
            message = "Person: ".concat(person.getPersonFirstName()).concat(" ").concat(person.getPersonLastName()).concat(" is deleted");
        }
        userRepository.deleteById(userId);
        return message;
    }

    @Override
    public Person getUser(String userName) {
        return userRepository.findByPersonFirstNameIgnoreCase(userName);
    }
}
