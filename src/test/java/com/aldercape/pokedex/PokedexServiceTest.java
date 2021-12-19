package com.aldercape.pokedex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokedexServiceTest {

    private PokemonRepository repository = name ->
        new Pokemon(name,
                "It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.",
                false,
                "rare");

    private TranslationService translation = text -> "Created by a scientist after years of horrific gene splicing and DNA engineering experiments, it was.";

    private PokedexService service = new PokedexService(repository, translation);

    @Test
    public void testGetPokemon() {
        var result = service.getPokemon("mewtwo");
        assertEquals("mewtwo", result.name());
        assertEquals("It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.", result.description());
        assertEquals(false, result.legendary());
        assertEquals("rare", result.habitat());
    }

    @Test
    public void testGetTranslatedPokemon() {
        var result = service.getTranslatedPokemon("mewtwo");
        assertEquals("mewtwo", result.name());
        assertEquals("Created by a scientist after years of horrific gene splicing and DNA engineering experiments, it was.", result.description());
        assertEquals(false, result.legendary());
        assertEquals("rare", result.habitat());
    }
}
