package com.aldercape.pokedex;

public class PokedexService {
    public Pokemon getPokemon(String name) {
        // legendary https://pokeapi.co/api/v2/pokemon-species/{id or name}/
        // habitat https://pokeapi.co/api/v2/pokemon-species/{id or name}/
        // flavor_text_entries description https://pokeapi.co/api/v2/pokemon-species/{id or name}/


        return new Pokemon(name,
                "It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.",
                false,
                "rare");
    }
}
