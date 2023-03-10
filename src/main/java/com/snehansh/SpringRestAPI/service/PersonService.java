package com.snehansh.SpringRestAPI.service;

import com.snehansh.SpringRestAPI.entity.Person;
import com.snehansh.SpringRestAPI.error.PersonNotFoundException;

import java.util.List;

public interface PersonService {
    public Person saveUser(Person person);

    public List<Person> getUser();

    public Person getUser(Long userId) throws PersonNotFoundException;

    public Person updateUser(Long userId, Person person);

    public String deleteUser(Long userId);
}
