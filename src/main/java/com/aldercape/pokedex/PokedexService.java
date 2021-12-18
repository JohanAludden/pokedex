package com.aldercape.pokedex;

public class PokedexService {

    private PokemonRepository repository;

    public PokedexService(PokemonRepository repository) {
        this.repository = repository;
    }

    public Pokemon getPokemon(String name) {
        // legendary https://pokeapi.co/api/v2/pokemon-species/{id or name}/
        // habitat https://pokeapi.co/api/v2/pokemon-species/{id or name}/
        // flavor_text_entries description https://pokeapi.co/api/v2/pokemon-species/{id or name}/
        return repository.getPokemon(name);
    }
}
