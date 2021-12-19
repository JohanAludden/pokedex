package com.aldercape.pokedex.funtranslations;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class YodaTranslationServiceTest {

    @Test
    public void testTranslates() {
        var client = mock(RestTemplate.class);
        when(
                client.postForObject(
                        eq("https://api.funtranslations.com/translate/yoda.json"),
                        any(),
                        eq(String.class)))
                .thenReturn("{\n" +
                        "  \"success\": {\n" +
                        "    \"total\": 1\n" +
                        "  },\n" +
                        "  \"contents\": {\n" +
                        "    \"translation\": \"yoda\",\n" +
                        "    \"text\": \"Input.\",\n" +
                        "    \"translated\": \"Translated\"\n" +
                        "  }\n" +
                        "}");
        var service = new YodaTranslationService(client);
        var result = service.translate("To be translated");
        assertEquals("Translated", result);
    }
}
