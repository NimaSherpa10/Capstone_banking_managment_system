package com.backend.bankingManagmentSystem.services;

import com.backend.bankingManagmentSystem.entity.Loan;
import com.backend.bankingManagmentSystem.entity.User;
import com.backend.bankingManagmentSystem.repo.LoanRepo;
import com.backend.bankingManagmentSystem.repo.TransactionRepo;
import com.backend.bankingManagmentSystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    //apply For loan
    public void applyForLoan(Long userId, Loan loan) {
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent()) {
            loan.setUser(user.get());
            loan.setCreatedAt(new Date());
            loan.setStatus("pending");
            loanRepo.save(loan);
        }
        else {
            throw new RuntimeException("User Not Found");
        }
    }

    //get loan details by ID
    public  Loan getLoanById(Long loanId) {
        return loanRepo.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    //fetch all the loans taken by specific user
    public List<Loan> getAllLoansByUserId(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return loanRepo.findByUser(user);
    }

    //fetch the status of the loan
    public String getLoanStatus(Long loanId) {
        Loan loan = getLoanById(loanId);
        if(loan != null) {
           return loan.getStatus();
        }
        else {
            throw  new RuntimeException("Loan not found");
        }
    }

    // Approves or rejects a loan application
    public void updateLoanStatus(Long loanId, String status) {
        Loan loan = getLoanById(loanId);
        loan.setStatus(status);
        loan.setUpdatedAt(new Date()); // Optionally update the timestamp
        loanRepo.save(loan); // Save the updated loan
    }
    // Calculates monthly payment for a loan based on amount, interest rate, and tenure
    public double calculateMonthlyPayment(Long loanId) {
        Loan loan = getLoanById(loanId);
        double principal = loan.getTotalAmount();
        double monthlyInterestRate = loan.getInterestRate() / 12 / 100; // Convert annual interest rate to monthly and to decimal
        double tenureMonths = loan.getTenureMonths(); // Loan tenure in months

        // Monthly Payment = [P * r * (1 + r)^n] / [(1 + r)^n – 1]
        if (monthlyInterestRate == 0) { // If the interest rate is 0, return simple division
            return principal / tenureMonths;
        }

        double numerator = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureMonths);
        double denominator = Math.pow(1 + monthlyInterestRate, tenureMonths) - 1;

        return numerator / denominator;
    }

    // Fetches all loans currently pending approval
    public List<Loan> getAllPendingLoans() {
        return loanRepo.findByStatus("pending");
    }
    // Counts the number of payments made by a user for a specific loan
    public int countPaymentsByLoanId(Long loanId) {
            Loan loan = getLoanById(loanId);
           return loan.getPaymentCounter();
   }

    // Fetches all loans for admin view
    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }

}
