package com.aldercape.pokedex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PokedexController {

    private final PokedexService service;

    public PokedexController(PokedexService service) {
        this.service = service;
    }

    @GetMapping("/pokemon/{name}")
    public Pokemon getPokemon(@PathVariable String name) {
        return service.getPokemon(name);
    }

    @GetMapping("/pokemon/translated/{name}")
    public Pokemon getTranslatedPokemon(@PathVariable String name) {
        return service.getPokemon(name);
    }
}
