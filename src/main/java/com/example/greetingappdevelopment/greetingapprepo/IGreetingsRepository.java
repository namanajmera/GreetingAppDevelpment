package com.example.greetingappdevelopment.greetingapprepo;

import com.example.greetingappdevelopment.greetingappmodal.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGreetingsRepository extends JpaRepository<Greeting, Long> {

}