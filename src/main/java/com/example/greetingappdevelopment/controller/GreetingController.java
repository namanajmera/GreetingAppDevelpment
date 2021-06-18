package com.example.greetingappdevelopment.controller;

import com.example.greetingappdevelopment.greetingappconfigure.GreetingConfigure;
import com.example.greetingappdevelopment.greetingappmodal.Greeting;
import com.example.greetingappdevelopment.greetingappmodal.User;
import com.example.greetingappdevelopment.greetingappservice.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";

    @Autowired
    private IGreetingService greetingService;

    @GetMapping(value = { "", "/", "/home" })
    public Greeting getGreeting(@RequestParam(value = "fName", defaultValue = "") String firstName,
                                @RequestParam(value = "lName", defaultValue = "") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @GetMapping(value = { "/{id}", "/home/{id}" })
    public Greeting getGreeting(@PathVariable long id) {
        return greetingService.getGreetingById(id);
    }

    @PostMapping("/post")
    public String getGreeting(@RequestBody Greeting greeting) {
        return "{\"id\":" + greeting.getId() + ",\"message\":" + "\"" + String.format(template, greeting.getMessage())
                + "\"}";
    }

    @PutMapping("/put/{id}")
    public Greeting getGreeting(@PathVariable long id,
                                @RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(id, String.format(template, name));
    }
}
