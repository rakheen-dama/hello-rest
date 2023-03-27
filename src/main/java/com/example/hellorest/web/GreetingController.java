package com.example.hellorest.web;

import com.example.hellorest.dto.AddedGreeting;
import com.example.hellorest.dto.NewGreeting;
import com.example.hellorest.service.GreetingService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Greeting API", version = "v1"))
@SecurityRequirement(name = "basicAuth")
public class GreetingController {

    private final GreetingService greetingService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AddedGreeting addGreeting(@RequestBody NewGreeting newGreeting) {
        return greetingService.addGreeting(newGreeting);
    }

    @GetMapping
    public List<AddedGreeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @GetMapping("/free")
    public String freeGreeting() {
        return "Hello free world";
    }
}
