package com.auth.securityplayground.controller;

import com.auth.securityplayground.models.Customer;
import com.auth.securityplayground.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RegisterController {

    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        try {
            Customer savedCustomer = customerRepository.save(customer);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("User has been saved");

        }
        catch (Exception exp){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Exception occurred " + exp.getMessage());
        }
    }


}
