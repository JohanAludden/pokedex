package com.aldercape.pokedex.funtranslations;

import com.aldercape.pokedex.TranslationService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;

@Service
public class YodaTranslationService implements TranslationService {

    @Override
    public String translate(String text) {
        executeHttpPostRequest("https://api.funtranslations.com/translate/yoda.json");
        return "Translated";
    }

    public InputStream executeHttpPostRequest(String url) {
        return null;
    }

}
