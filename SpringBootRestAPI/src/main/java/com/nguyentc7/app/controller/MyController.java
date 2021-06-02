package com.nguyentc7.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser(){
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication());
    }
}
