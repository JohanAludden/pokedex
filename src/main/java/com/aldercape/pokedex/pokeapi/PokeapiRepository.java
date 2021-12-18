package com.aldercape.pokedex.pokeapi;

import com.aldercape.pokedex.Pokemon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PokeapiRepository {

    // legendary https://pokeapi.co/api/v2/pokemon-species/{id or name}/
    // habitat https://pokeapi.co/api/v2/pokemon-species/{id or name}/
    // flavor_text_entries description https://pokeapi.co/api/v2/pokemon-species/{id or name}/

    public Pokemon getPokemonByName(String name) {
        try {
            String json = executeHttpGetRequest();
            var mapper = new ObjectMapper();
            var parsedValue = mapper.readValue(json, new TypeReference<Map<String,Object>>(){});
            var legendary = (Boolean)parsedValue.get("is_legendary");
            var description = (String)((Map<String, Object>) ((List) parsedValue.get("flavor_text_entries")).get(0)).get("flavor_text");
            description = description.replace("\n", " ").replace("\f", " ");
            var habitat = (String)((Map<String, Object>)parsedValue.get("habitat")).get("name");
            System.out.println(habitat.getClass() + " " + habitat);
            return new Pokemon(name, description, legendary, habitat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String executeHttpGetRequest() {
        return "";
    }
}
