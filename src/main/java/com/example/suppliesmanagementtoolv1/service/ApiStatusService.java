package com.example.suppliesmanagementtoolv1.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

@Service
public class ApiStatusService {

    public ResponseEntity<Object> getStatus() {
        HashMap<String, String> entities = new HashMap<>();
        entities.put("status", "OK");
        entities.put("timestamp", String.valueOf(LocalDateTime.now()));

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

}
