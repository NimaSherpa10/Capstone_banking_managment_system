package com.backend.bankingManagmentSystem.rest;

import com.backend.bankingManagmentSystem.entity.Loan;
import com.backend.bankingManagmentSystem.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    //apply for loan
    @PostMapping("/apply/{userId}")
    public String applyForLoan(@PathVariable Long userId, @RequestBody Loan loan) {
        try {
            loanService.applyForLoan(userId, loan);
            return "Loan application submitted successfully";
        } catch (RuntimeException e) {
            return e.toString();
        }
    }

    //get loan by loan id
    @GetMapping("/{loanId}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long loanId) {
        try {
            Loan loan = loanService.getLoanById(loanId);
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //get all loan of the user by userID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Loan>> getAllLoansByUserId(@PathVariable Long userId) {
        List<Loan> loans = loanService.getAllLoansByUserId(userId);
        return ResponseEntity.ok(loans);
    }

    // Fetches the status of a loan based on loan ID
    @GetMapping("/{loanId}/status")
    public ResponseEntity<String> getLoanStatus(@PathVariable Long loanId) {
        String status = loanService.getLoanStatus(loanId);
        return ResponseEntity.ok(status);
    }

    // Approves or rejects a loan application
    @PutMapping("/{loanId}/status")
    public ResponseEntity<String> updateLoanStatus(@PathVariable Long loanId, @RequestParam String status) {
        loanService.updateLoanStatus(loanId, status);
        return ResponseEntity.ok("Loan status updated successfully to " + status);
    }
    // Calculate monthly payment for a specific loan
    @GetMapping("/{loanId}/monthly-payment")
    public ResponseEntity<Double> calculateMonthlyPayment(@PathVariable Long loanId) {
        double monthlyPayment = loanService.calculateMonthlyPayment(loanId);
        return ResponseEntity.ok(monthlyPayment);
    }

    // Fetches all loans currently pending approval
    @GetMapping("/pending")
    public ResponseEntity<List<Loan>> getAllPendingLoans() {
        List<Loan> pendingLoans = loanService.getAllPendingLoans();
        return ResponseEntity.ok(pendingLoans);
    }

    // Endpoint to get the payment count by loan ID
    @GetMapping("/{loanId}/payment-count")
    public ResponseEntity<Integer> getPaymentCount(@PathVariable Long loanId) {
        int paymentCount = loanService.countPaymentsByLoanId(loanId);
        return ResponseEntity.ok(paymentCount);
    }

    // Fetches all loans for admin view
    @GetMapping("/view")
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }
}
