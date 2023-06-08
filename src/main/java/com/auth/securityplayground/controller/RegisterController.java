package com.auth.securityplayground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegisterController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }


}
