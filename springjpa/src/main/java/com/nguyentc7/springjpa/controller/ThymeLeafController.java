package com.nguyentc7.springjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
@RequestMapping
public class ThymeLeafController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
