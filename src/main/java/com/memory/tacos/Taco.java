package com.memory.tacos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Taco {
    private final String id = UUID.randomUUID().toString();
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "you must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
