package com.example.hellorest.dto;

import java.time.LocalDateTime;

public record NewGreeting(String language, String greeting, Continent continent) { }
