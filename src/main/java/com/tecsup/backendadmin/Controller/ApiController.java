package com.tecsup.backendadmin.Controller;

import com.tecsup.backendadmin.Service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/api/data")
    public Object[] getData() {
        return apiService.fetchData();
    }
}



