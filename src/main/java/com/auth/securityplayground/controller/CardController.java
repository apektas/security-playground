package com.auth.securityplayground.controller;

import com.auth.securityplayground.models.Card;
import com.auth.securityplayground.models.Customer;
import com.auth.securityplayground.repository.CardRepository;
import com.auth.securityplayground.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CardController {

    private final CardRepository cardRepository;

    private final CustomerRepository customerRepository;

    @GetMapping("/myCards")
    public List<Card> getCardDetails(@RequestParam String email){
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Card> cards = cardRepository.findByCustomerId(customers.get(0).getCustomerId());
            if (cards != null ) {
                return cards;
            }
        }
        return null;
    }


}
