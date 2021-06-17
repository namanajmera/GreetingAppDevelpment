package com.example.greetingappdevelopment.greetingappservice;

import com.example.greetingappdevelopment.greetingappmodal.Greeting;
import com.example.greetingappdevelopment.greetingappmodal.User;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {
    @Override
    public String getMessage() {
        return "Hello World!!";
    }

    @Override
    public String getMessage(User user) {
        if (user == null) {
            return "Hello World";
        } else if (user.getFirstName() == null) {
            user.setFirstName("");
            return "Hello " + user.getLastName();
        } else if (user.getLastName() == null) {
            user.setLastName("");
            return "Hello " + user.getFirstName();
        } else {
            return "Hello " + user.getFirstName() + " " + user.getLastName() + "!";
        }
    }
}
