package com.example.hellorest.service;

import com.example.hellorest.dto.AddedGreeting;
import com.example.hellorest.dto.NewGreeting;
import com.example.hellorest.persistence.Greeting;
import com.example.hellorest.persistence.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Setter
@RequiredArgsConstructor
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public AddedGreeting addGreeting(NewGreeting newGreeting) {
        Greeting greeting = Greeting.fromNewGreeting(newGreeting);
        return AddedGreeting.fromPersistedGreeting(greetingRepository.save(greeting));
    }

    public List<AddedGreeting> getAllGreetings() {
        return greetingRepository.findAll()
                .stream()
                .map(AddedGreeting::fromPersistedGreeting)
                .collect(Collectors.toList());

    }
}
