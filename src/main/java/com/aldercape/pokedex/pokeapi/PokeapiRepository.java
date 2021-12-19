package com.aldercape.pokedex.pokeapi;

import com.aldercape.pokedex.Pokemon;
import com.aldercape.pokedex.PokemonRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Repository
public class PokeapiRepository implements PokemonRepository {

    private final RestTemplate client;

    public PokeapiRepository(RestTemplate client) {
        this.client = client;
    }

    private ObjectMapper mapper = new ObjectMapper();

    public Pokemon getPokemonByName(String name) {
        try {
            var json = executeHttpGetRequest("https://pokeapi.co/api/v2/pokemon-species/" + name);
            var parsedValue = mapper.readValue(json, new TypeReference<Map<String,Object>>(){});
            var legendary = getLegendary(parsedValue);
            var description = getDescription(parsedValue);
            var habitat = getHabitat(parsedValue);
            return new Pokemon(name, description, legendary, habitat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getHabitat(Map<String, Object> parsedValue) {
        return (String)((Map<String, Object>) parsedValue.get("habitat")).get("name");
    }

    private String getDescription(Map<String, Object> parsedValue) {
        var result = (String)((Map<String, Object>) ((List) parsedValue.get("flavor_text_entries")).get(0)).get("flavor_text");
        return result.replace("\n", " ").replace("\f", " ");
    }

    private Boolean getLegendary(Map<String, Object> parsedValue) {
        return (Boolean) parsedValue.get("is_legendary");
    }

    public String executeHttpGetRequest(String url) {
        return client.getForObject(url, String.class);
    }
}
