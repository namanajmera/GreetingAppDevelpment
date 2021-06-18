package com.example.greetingappdevelopment.greetingappservice;

import com.example.greetingappdevelopment.greetingappconfigure.GreetingConfigure;
import com.example.greetingappdevelopment.greetingappmodal.Greeting;
import com.example.greetingappdevelopment.greetingappmodal.User;

public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);
}
