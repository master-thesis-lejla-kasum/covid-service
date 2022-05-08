package com.master.covidservice.covidservice.rest;

import com.master.covidservice.covidservice.dto.AuthResponse;
import com.master.covidservice.covidservice.exception.AccessForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AuthServiceClient {

    private final RestTemplate restTemplate;
    private final String BASE_URL;
    private final String PATH;

    @Autowired
    public AuthServiceClient(
            RestTemplate restTemplate,
            @Value("${auth.base-url}") String baseUrl,
            @Value("${auth.path}") String path
    ) {
        this.restTemplate = restTemplate;
        this.BASE_URL = baseUrl;
        this.PATH = path;
    }

    public AuthResponse validateToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        String uri = BASE_URL.concat(PATH);

        UriComponents components = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("token", token)
                .build();

        ResponseEntity<AuthResponse> response = restTemplate.exchange(components.toUriString(), HttpMethod.POST, requestEntity, AuthResponse.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new AccessForbiddenException("Invalid token");
        }

        return response.getBody();

    }
}
