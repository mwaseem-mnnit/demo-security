package com.example.demosecurity.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Created by mohd.waseem on 21/06/20.
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("test")
    public ResponseEntity<String> testGet(@RequestParam String query) {
        System.out.println("test query is : "+query);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("SUCCESS");
    }

    @GetMapping("redirect")
    public ResponseEntity<String> testRedirect(@RequestParam String query) {
        System.out.println("redirect query is : "+query);
        return ResponseEntity.status(301).location(URI.create("http://localhost:8080/demo/test?query=query")).body("Redirect");
    }

    @PostMapping("test/post")
    public ResponseEntity<String> testPost(@RequestParam String query) {
        System.out.println("test post query is : "+query);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("SUCCESS");
    }

    @PostMapping("redirect/post")
    public ResponseEntity<String> testRedirectPost(@RequestParam String query) {
        System.out.println("redirect post query is : "+query);
        return ResponseEntity.status(301).location(URI.create("http://localhost:8080/demo/test?query=query")).body("Redirect");
    }
}
