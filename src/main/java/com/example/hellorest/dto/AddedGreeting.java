package com.example.hellorest.dto;

import com.example.hellorest.persistence.Greeting;

import java.time.LocalDateTime;
import java.time.ZoneId;

public record AddedGreeting(Long id, String language, String greeting, Continent continent, String addedBy, LocalDateTime modifiedOn) {

    public static AddedGreeting fromPersistedGreeting(Greeting greeting) {
        return new AddedGreeting(
                greeting.getId(),
                greeting.getLanguage(),
                greeting.getGreeting(),
                greeting.getContinent(),
                greeting.getCreatedBy(),
                LocalDateTime.ofInstant(greeting.getCreatedDate().toInstant(), ZoneId.systemDefault()));
    }
}
