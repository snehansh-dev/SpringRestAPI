package com.snehansh.SpringRestAPI.controller;

import com.snehansh.SpringRestAPI.entity.Person;
import com.snehansh.SpringRestAPI.error.PersonNotFoundException;
import com.snehansh.SpringRestAPI.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService userService;
    private Logger LOGGER = LoggerFactory.getLogger(Logger.class);
    @PostMapping("/user")
    public Person saveUser(@RequestBody Person person){
        LOGGER.info("Person is crated");
        return userService.saveUser(person);
    }

    @GetMapping("/user")
    public List<Person> getUser(){
        LOGGER.info("List of All Persons has requested");
        return userService.getUser();
    }

    @GetMapping("/user/{id}")
    public Person getUser(@PathVariable("id") Long userId) throws PersonNotFoundException {
        LOGGER.info("Person information fetched by User Id");
        return userService.getUser(userId);
    }

    @PutMapping("/user/{id}")
    public Person updateUser(@PathVariable("id") Long userId, @RequestBody Person person){
        LOGGER.info("Person information has updated by userId and data");
        return userService.updateUser(userId, person);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long userId){
        LOGGER.info("Person information has deleted based on user Id");
        return userService.deleteUser(userId);
    }
}
