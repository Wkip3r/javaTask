package org.example.api;

import org.example.entity.DetectLanguageRequest;
import org.example.entity.DetectLanguageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class YandexApi extends LanguageApi {

    @Value("${api.detectLanguageUrl}")
    private String url;

    @Value("${yandex.token}")
    private String apiKey;

    @Value("${yandex.folderId}")
    private String folderId;

    public String getRowLanguage(String text) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<DetectLanguageRequest> request = new HttpEntity<>(new DetectLanguageRequest(text,null,folderId),headers);

        ResponseEntity<DetectLanguageResponse> response = restTemplate
                .exchange(url, HttpMethod.POST, request, DetectLanguageResponse.class);

        DetectLanguageResponse detectLanguageResponse = response.getBody();

        return detectLanguageResponse.getLanguageCode();
    }
}
