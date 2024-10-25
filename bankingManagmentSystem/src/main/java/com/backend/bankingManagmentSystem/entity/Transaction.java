package com.backend.bankingManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Double paymentAmount;
    private Date timestamp;
    private String paymentStatus;
    private double remainingBalance;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "loan_id",nullable = false)
    private Loan loan;
}
