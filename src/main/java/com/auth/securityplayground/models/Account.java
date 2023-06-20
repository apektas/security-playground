package com.auth.securityplayground.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number", columnDefinition = "serial")
    Long accountNumber;

    @Column(name = "customer_id")
    private Integer customerId;


    @Column(name="account_type")
    private String accountType;

    // @Column(name = "branch_address")
    @Column
    private String branchAddress;

    @Column(name = "create_dt")
    private Instant createDt;
}
