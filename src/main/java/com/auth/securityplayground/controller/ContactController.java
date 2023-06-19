package com.auth.securityplayground.controller;


import com.auth.securityplayground.models.Contact;
import com.auth.securityplayground.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

@RestController
@AllArgsConstructor
public class ContactController {

    private ContactRepository contactRepository;
    @GetMapping("/contact")
    public String getContacts(){
        return "get Contacts";
    }

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(Instant.now());
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ranNum;
    }

}
