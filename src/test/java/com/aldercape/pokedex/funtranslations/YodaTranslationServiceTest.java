package com.aldercape.pokedex.funtranslations;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class YodaTranslationServiceTest {

    @Test
    public void testTranslates() {
        var client = mock(RestTemplate.class);
        when(
                client.getForObject(
                        eq("https://api.funtranslations.com/translate/yoda?text=Input"),
                        eq(String.class)))
                .thenReturn(response);
        var service = new YodaTranslationService(client);
        var result = service.translate("Input");
        assertEquals("Translated", result);
    }

    @Test
    @Disabled
    // This could be disabled if we want to manually test the connection to the remote api.
    public void testTranslateWithRemoteRequest() {
        var service = new YodaTranslationService(new RestTemplate());
        var result = service.translate("This is a test");

        assertEquals("This%20is%20a%20test", result);
    }

    private String response = "{\n" +
            "  \"success\": {\n" +
            "    \"total\": 1\n" +
            "  },\n" +
            "  \"contents\": {\n" +
            "    \"translation\": \"yoda\",\n" +
            "    \"text\": \"Input.\",\n" +
            "    \"translated\": \"Translated\"\n" +
            "  }\n" +
            "}";
}
