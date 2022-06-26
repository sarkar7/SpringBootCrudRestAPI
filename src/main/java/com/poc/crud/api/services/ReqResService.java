package com.poc.crud.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReqResService {

    Logger logger = LoggerFactory.getLogger(ReqResService.class);

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getAllUsers(String userUrl) {
        try {
           return restTemplate.getForEntity(userUrl, String.class);
        } catch (RestClientException e) {
            logger.error("Query failed due to ", e);
            return null;
        }
    }

    public String getOneUsers(String userUrl) {
        try {
            return restTemplate.getForEntity(userUrl, String.class).toString();
        } catch (RestClientException e) {
            logger.error("Query failed due to ", e);
            return "a";
        }
    }

    public String createSingleUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, String> map = new HashMap<>();
        map.put("name", "John Doe");
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(map, headers);
        try {
            return restTemplate.postForObject("https://reqres.in/api/users", entity, String.class);
        } catch (RestClientException e) {
            logger.error("Query failed due to ", e);
            return null;
        }
    }
}
