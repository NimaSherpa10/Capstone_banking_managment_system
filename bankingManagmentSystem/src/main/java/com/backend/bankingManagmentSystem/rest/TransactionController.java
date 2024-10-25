package com.backend.bankingManagmentSystem.rest;

import com.backend.bankingManagmentSystem.entity.Transaction;
import com.backend.bankingManagmentSystem.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    // Endpoint to make a loan payment
    @PostMapping("/payments")
    public ResponseEntity<Void> makeLoanPayment(
            @RequestParam Long loanId,
            @RequestParam double paymentAmount) {
        try {
            transactionService.makeLoanPayment(loanId, paymentAmount);
            return ResponseEntity.ok().build(); // Return 200 OK on successful payment
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null); // Return 400 Bad Request on error
        }
    }
    // Endpoint to fetch all transactions related to a specific loan
    @GetMapping("/{loanId}/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactionsByLoanId(@PathVariable Long loanId) {
        List<Transaction> transactions = transactionService.getAllTransactionsByLoanId(loanId);
        return ResponseEntity.ok(transactions); // Return the list of transactions
    }

    // Endpoint to calculate remaining balance for a specific loan
    @GetMapping("/{loanId}/remaining-balance")
    public ResponseEntity<Double> calculateRemainingBalance(@PathVariable Long loanId) {
        double remainingBalance = transactionService.calculateRemainingBalance(loanId);
        return ResponseEntity.ok(remainingBalance); // Return the remaining balance
    }

}
