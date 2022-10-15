package com.example.pablex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Healthcheck {
    
    @GetMapping(value="/health/")
    public ResponseEntity<Boolean> health() {
        return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
    }
   
}