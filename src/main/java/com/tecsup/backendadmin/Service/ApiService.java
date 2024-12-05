package com.tecsup.backendadmin.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object[] fetchData() {
        String url = "https://api-proyecto-integrador.onrender.com/api/";
        return restTemplate.getForObject(url, Object[].class);
    }
}

