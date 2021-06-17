package com.example.greetingappdevelopment.controller;

import com.example.greetingappdevelopment.greetingappmodal.Greeting;
import com.example.greetingappdevelopment.greetingappmodal.User;
import com.example.greetingappdevelopment.greetingappservice.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/get/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/post")
    public String greetUser(@RequestBody User user) {
        return greetingService.getMessage(user);
    }

}
