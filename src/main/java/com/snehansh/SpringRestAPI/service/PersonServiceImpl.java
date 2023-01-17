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
        if(Objects.nonNull(person.getUserFirstName()) &&
        !"".equalsIgnoreCase(person.getUserFirstName())){
            persondb.setUserFirstName(person.getUserFirstName());
        }

        if(Objects.nonNull(person.getUserLastName()) &&
        !"".equalsIgnoreCase(person.getUserLastName())){
            persondb.setUserLastName(person.getUserLastName());
        }
        if(Objects.nonNull(person.getUserAddress()) &&
        !"".equalsIgnoreCase(person.getUserAddress())){
            persondb.setUserAddress(person.getUserAddress());
        }
        if(Objects.nonNull(person.getUserEmail()) &&
        !"".equalsIgnoreCase(person.getUserEmail())){
            persondb.setUserEmail(person.getUserEmail());
        }
        if(Objects.nonNull(person.getUserContact()) &&
        !"".equalsIgnoreCase(person.getUserContact())){
            persondb.setUserContact(person.getUserContact());
        }
        return userRepository.save(persondb);
    }

    @Override
    public String deleteUser(Long userId) {
        Person person = userRepository.findById(userId).get();
        String message;
        if(person.getUserFirstName().isBlank()){
            message = "Invalid User Id";
        }else{
            message = "Person: ".concat(person.getUserFirstName()).concat(" ").concat(person.getUserLastName()).concat(" is deleted");
        }
        userRepository.deleteById(userId);
        return message;
    }
}
