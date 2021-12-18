package com.aldercape.pokedex;

import org.springframework.stereotype.Service;

@Service
public class PokedexService {

    private PokemonRepository repository;

    public PokedexService(PokemonRepository repository) {
        this.repository = repository;
    }

    public Pokemon getPokemon(String name) {
        return repository.getPokemonByName(name);
    }
}
