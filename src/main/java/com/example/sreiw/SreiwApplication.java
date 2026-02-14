package com.example.sreiw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.sreiw")
public class SreiwApplication {


    public static void main(String[] args) {
        SpringApplication.run(SreiwApplication.class, args);
    }
}
