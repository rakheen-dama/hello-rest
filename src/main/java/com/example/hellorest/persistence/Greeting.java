package com.example.hellorest.persistence;

import com.example.hellorest.dto.Continent;
import com.example.hellorest.dto.NewGreeting;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Greeting extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String greeting;
    private String language;

    @Enumerated(EnumType.STRING)
    private Continent continent;

    public static Greeting fromNewGreeting(NewGreeting newGreeting) {
        var greeting = new Greeting();
        greeting.setId(1l);
        greeting.setGreeting(newGreeting.greeting());
        greeting.setLanguage(newGreeting.language());
        greeting.setContinent(newGreeting.continent());
        return greeting;
    }
}
