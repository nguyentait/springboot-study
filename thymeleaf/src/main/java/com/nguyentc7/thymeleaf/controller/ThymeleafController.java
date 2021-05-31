package com.nguyentc7.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class ThymeleafController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/date")
    public String date(Model model){
        model.addAttribute("date",new Date());
        return "date";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("name","Ta Chi Nguyen");
        return "about";
    }
}
