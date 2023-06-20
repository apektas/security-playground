package com.auth.securityplayground.repository;

import com.auth.securityplayground.models.Customer;
import com.auth.securityplayground.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    // @PreAuthorize("hasRole('ROOT')")
    // we can use method security at any level
    List<Loan> findByCustomerIdOrderByStartDtDesc(Integer customerId);
}
