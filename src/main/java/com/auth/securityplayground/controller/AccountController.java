package com.auth.securityplayground.controller;

import com.auth.securityplayground.models.Account;
import com.auth.securityplayground.models.Customer;
import com.auth.securityplayground.repository.AccountRepository;
import com.auth.securityplayground.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccount(){
        return "My Account";
    }


}
