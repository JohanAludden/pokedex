package com.aldercape.pokedex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokedexServiceTest {

    private String pokemonName;

    @Test
    public void testGetPokemon() {
        var repository = new PokemonRepository(){

            @Override
            public Pokemon getPokemon(String name) {
                pokemonName = name;
                return new Pokemon(name,
                        "It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.",
                        false,
                        "rare");
            }
        };
        var service = new PokedexService(repository);
        var result = service.getPokemon("mewtwo");
        assertEquals("mewtwo", result.name());
        assertEquals("It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.", result.description());
        assertEquals(false, result.legendary());
        assertEquals("rare", result.habitat());
    }
}
