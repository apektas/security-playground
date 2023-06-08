package com.auth.securityplayground.repository;

import com.auth.securityplayground.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByCustomerId(Long id);
}
