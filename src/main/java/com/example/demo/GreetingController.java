package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Spring Boot API!";

    }
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.ok()
                .header("Custom-Header", "SuccessHeader")
                .body("Request was successful!");
    }
    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: Resource not found!");
    }
    @PostMapping("/create")
    public ResponseEntity<String> create() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/new-resource")
                .body("Resource created!");
    }

}