package com.nguyentc7.springjpa;

import com.nguyentc7.springjpa.controller.ThymeLeafController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjpaApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(SpringjpaApplication.class, args);
        System.out.println(context.getBean(ThymeLeafController.class));

    }
}
