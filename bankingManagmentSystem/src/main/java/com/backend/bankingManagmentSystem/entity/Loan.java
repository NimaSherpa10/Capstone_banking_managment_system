package com.backend.bankingManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private String loanType;
    private double totalAmount;
    private double interestRate;
    private double tenureMonths;
    private String status;
    private int paymentCounter;
    private double downPayment;
    private Date createdAt;
    private Date updatedAt;
    private double totalPaidAmount;
    private double remainingBalance;
    private boolean isElligible;
    private String loanDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}
