package com.aldercape.pokedex;

public class PokedexService {

    private PokemonRepository repository;

    public PokedexService(PokemonRepository repository) {
        this.repository = repository;
    }

    public Pokemon getPokemon(String name) {
        return repository.getPokemon(name);
    }
}
