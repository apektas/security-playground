package com.auth.securityplayground.repository;

import com.auth.securityplayground.models.Account;
import com.auth.securityplayground.models.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, String> {
    List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(Integer customerId);
}
