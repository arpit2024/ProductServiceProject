package com.example.productserviceproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Controller will get the request from the user and then call th e relevant service
//when it get the response from service controller will give it back to user
@RestController
@RequestMapping("/hello/{name}")
public class HelloController {

    @GetMapping("/say")
    public String sayHello(@PathVariable("name") String name){
    return "HELLO THERE "+ name;
    }
}
