package com.aldercape.pokedex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokedexServiceTest {

    @Test
    public void testGetPokemon() {
        var service = new PokedexService();
        var result = service.getPokemon("mewtwo");
        assertEquals("mewtwo", result.name());
        assertEquals("It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.", result.description());
        assertEquals(false, result.legendary());
        assertEquals("rare", result.habitat());
    }
}
