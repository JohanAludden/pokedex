package com.aldercape.pokedex;

public record Pokemon(String name, String description, boolean legendary, String habitat) {
    public Pokemon withDescription(String description) {
        return new Pokemon(name, description, legendary, habitat);
    }
}
