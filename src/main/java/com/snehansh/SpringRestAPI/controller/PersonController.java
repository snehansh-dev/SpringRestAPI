package com.snehansh.SpringRestAPI.controller;

import com.snehansh.SpringRestAPI.entity.Person;
import com.snehansh.SpringRestAPI.service.PersonService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService userService;
    private final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    @PostMapping("/user")
    public Person saveUser(@Valid @RequestBody Person person){
        LOGGER.info("Inside saveUser of PersonService Class");
        return userService.saveUser(person);
    }

    @GetMapping("/user")
    public List<Person> getUser(){
        LOGGER.info("Inside getUser of PersonService Class to get All users");
        return userService.getUser();
    }
    @GetMapping("/user/{id}")
    public Person getUser(@PathVariable("id") Long userId){
        return userService.getUser(userId);
    }
    @GetMapping("/user/name/{name}")
    public Person getUser(@PathVariable("name") String userName){
        return userService.getUser(userName);
    }

    @PutMapping("/user/{id}")
    public Person updateUser(@PathVariable("id") Long userId, @RequestBody Person person){
        return userService.updateUser(userId, person);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long userId){
        return userService.deleteUser(userId);
    }
}
