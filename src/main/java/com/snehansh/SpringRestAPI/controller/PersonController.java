package com.snehansh.SpringRestAPI.controller;

import com.snehansh.SpringRestAPI.entity.Person;
import com.snehansh.SpringRestAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService userService;
    @PostMapping("/user")
    public Person saveUser(@RequestBody Person person){
        return userService.saveUser(person);
    }

    @GetMapping("/user")
    public List<Person> getUser(){
        return userService.getUser();
    }

    @GetMapping("/user/{id}")
    public Person getUser(@PathVariable("id") Long userId){
        return userService.getUser(userId);
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
