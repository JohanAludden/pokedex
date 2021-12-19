package com.aldercape.pokedex.funtranslations;

import com.aldercape.pokedex.TranslationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Service
public class YodaTranslationService implements TranslationService {

    private ObjectMapper mapper = new ObjectMapper();

    private final RestTemplate client;

    public YodaTranslationService(RestTemplate client) {
        this.client = client;
    }

    @Override
    public String translate(String text) {
        try {
            var json = executeHttpPostRequest("https://api.funtranslations.com/translate/yoda", text);
            var parsedValue = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
            var result = (String)((Map<String, Object>)parsedValue.get("contents")).get("translated");
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String executeHttpPostRequest(String url, String text) {
        var fullUrl = UriComponentsBuilder.fromHttpUrl(url).queryParam("text", text).encode().toUriString();
        return client.getForObject(fullUrl, String.class);
    }

}
