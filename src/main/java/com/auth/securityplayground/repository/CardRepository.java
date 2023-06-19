package com.auth.securityplayground.repository;

import com.auth.securityplayground.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findByCustomerId(Integer customerId);
}
