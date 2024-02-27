package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.service.ApiStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiStatusController {

    private final ApiStatusService apiStatusService;

    public ApiStatusController(ApiStatusService apiStatusService) {
        this.apiStatusService = apiStatusService;
    }

    @GetMapping(path = "/api-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getApiStatus() {
        return apiStatusService.getStatus();
    }
}
