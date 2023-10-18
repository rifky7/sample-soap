package com.example.demo2.service;

import com.example.demo2.config.BackendConfig;
import com.example.demo2.dto.RequestDTO;
import com.example.demo2.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Service
public class SampleServiceBackendService {

    private final RestTemplate restTemplate;

    @Autowired
    private  BackendConfig backendConfig;

    public SampleServiceBackendService() {
        restTemplate = new RestTemplate();
    }

    private HttpHeaders generateHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return headers;
    }

    public ResponseDTO getSampleData(RequestDTO requestDTO) {
        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(backendConfig.getUrl() + backendConfig.getSampleServiceEndpoint())
                .build();
        HttpHeaders headers = generateHeaders();
        try {
            return restTemplate.postForObject(
                    uriComponents.toUri(),
                    new HttpEntity<>(requestDTO, headers),
                    ResponseDTO.class
            );
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
