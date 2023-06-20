package com.auth.securityplayground.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping("/myLoans")
    //@PreAuthorize("hasRole('ROOT')") // will get 401 unauthorized cause there is no ROOT role
    @PreAuthorize("hasRole('USER')")
    public String getLoans(){
        return "My Loans";
    }


}
