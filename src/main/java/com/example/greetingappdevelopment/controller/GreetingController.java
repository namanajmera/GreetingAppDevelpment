package com.example.greetingappdevelopment.controller;

import com.example.greetingappdevelopment.greetingappconfigure.GreetingConfigure;
import com.example.greetingappdevelopment.greetingappmodal.Greeting;
import com.example.greetingappdevelopment.greetingappmodal.User;
import com.example.greetingappdevelopment.greetingappservice.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @RequestMapping("/get")
    public String greetingMessage() {
        return greetingService.getMessage();
    }

    @PostMapping("/post")
    public String greetUser(@RequestBody User user) {
        return greetingService.getMessage(user);
    }

    @PostMapping("/save")
    public ResponseEntity<Greeting> saveGreeting(@Valid @RequestBody GreetingConfigure greetingconfig) {
        Greeting greeting = greetingService.saveGreeting(greetingconfig);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
