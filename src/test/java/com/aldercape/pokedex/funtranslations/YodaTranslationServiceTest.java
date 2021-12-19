package com.aldercape.pokedex.funtranslations;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YodaTranslationServiceTest {

    private String calledUrl;

    @Test
    public void testTranslates() {
        var service = new YodaTranslationService(){
            public InputStream executeHttpPostRequest(String url) {
                calledUrl = url;
                return new ByteArrayInputStream("Translated".getBytes());
            }
        };
        var result = service.translate("To be translated");
        assertEquals("https://api.funtranslations.com/translate/yoda.json", calledUrl);
        assertEquals("Translated", result);
    }
}
