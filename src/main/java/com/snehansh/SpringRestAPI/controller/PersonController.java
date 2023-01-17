package com.snehansh.SpringRestAPI.controller;

import com.snehansh.SpringRestAPI.entity.Person;
import com.snehansh.SpringRestAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService userService;
    @PostMapping("/user")
    public Person saveUser(@RequestBody Person person){
        return userService.saveUser(person);
    }
}
