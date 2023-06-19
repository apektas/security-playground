package com.auth.securityplayground.repository;

import com.auth.securityplayground.models.Card;
import com.auth.securityplayground.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
