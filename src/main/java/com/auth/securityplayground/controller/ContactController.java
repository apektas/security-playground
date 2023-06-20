package com.auth.securityplayground.controller;


import com.auth.securityplayground.models.Contact;
import com.auth.securityplayground.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    //@PreFilter("!filterObject.contactName.equals('Test')") // remove contact is contactName == Test
    @PostFilter("!filterObject.contactName.equals('Test')") // remove contact is contactName == Test
    // prefilter and postfilter  works on collection type parameter
    public List<Contact> saveContactInquiryDetails(@RequestBody List<Contact> contacts) {
        Contact contact = contacts.get(0);
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(Instant.now());
        Contact savedContact = contactRepository.save(contact);

        List<Contact> contactList = new ArrayList<>();
        contactList.add(savedContact);
        return contactList;
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ranNum;
    }

}
