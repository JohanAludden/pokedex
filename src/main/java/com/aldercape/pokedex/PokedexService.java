package com.aldercape.pokedex;

import org.springframework.stereotype.Service;

@Service
public class PokedexService {

    private TranslationService translation;
    private PokemonRepository repository;

    public PokedexService(PokemonRepository repository, TranslationService translation) {
        this.repository = repository;
        this.translation = translation;
    }

    public Pokemon getPokemon(String name) {
        return repository.getPokemonByName(name);
    }

    public Pokemon getTranslatedPokemon(String name) {
        var result = getPokemon(name);
        return result.withDescription(translation.translate(result.description()));
    }
}
