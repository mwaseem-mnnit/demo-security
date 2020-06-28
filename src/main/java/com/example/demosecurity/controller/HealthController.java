package com.example.demosecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mohd.waseem on 28/06/20.
 */
@RestController
public class HealthController {
    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok().body("SUCCESS");
    }
}
