package com.nguyentc7.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController{
    @GetMapping("/hello")
    public ResponseEntity<?> getGreeting(){
        return ResponseEntity.ok("Hello world");
    }
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(){
        return ResponseEntity.ok("Profile");
    }
}
