package com.example.demosecurity.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mohd.waseem on 21/06/20.
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping("test")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("SUCCESS");
    }
}
