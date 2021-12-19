package com.aldercape.pokedex.funtranslations;

import com.aldercape.pokedex.TranslationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;

@Service
public class YodaTranslationService implements TranslationService {

    private final RestTemplate client;

    public YodaTranslationService(RestTemplate client) {
        this.client = client;
    }

    @Override
    public String translate(String text) {
        executeHttpPostRequest("https://api.funtranslations.com/translate/yoda.json");
        return "Translated";
    }

    public String executeHttpPostRequest(String url) {
        HttpEntity<String> request = new HttpEntity<>("");
        return client.postForObject(url, request, String.class);
    }

}
