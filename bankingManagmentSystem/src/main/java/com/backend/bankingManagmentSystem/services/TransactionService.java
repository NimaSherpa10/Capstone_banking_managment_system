package com.backend.bankingManagmentSystem.services;

import com.backend.bankingManagmentSystem.entity.Loan;
import com.backend.bankingManagmentSystem.entity.Transaction;
import com.backend.bankingManagmentSystem.repo.LoanRepo;
import com.backend.bankingManagmentSystem.repo.TransactionRepo;
import com.backend.bankingManagmentSystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private LoanService loanService;

    @Autowired
    private UserRepo userRepo;

    public void makeLoanPayment(Long loanId, double paymentAmount) {
        // Fetch the loan by its ID to ensure it exists
        Loan loan = loanRepo.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));

        // Check if the payment amount exceeds the remaining balance
        if (paymentAmount > loan.getRemainingBalance()) {
            throw new RuntimeException("Payment amount exceeds the remaining balance of the loan.");
        }

        // Update the remaining balance
        double newRemainingBalance = loan.getRemainingBalance() - paymentAmount;
        loan.setRemainingBalance(newRemainingBalance);

        // Update the total paid amount and increment the payment counter
        loan.setTotalPaidAmount(loan.getTotalPaidAmount() + paymentAmount);
        loan.setPaymentCounter(loan.getPaymentCounter() + 1);

        // Create a new transaction to record this payment
        Transaction transaction = new Transaction();
        transaction.setPaymentAmount(paymentAmount);
        transaction.setTimestamp(new Date());  // Set the current timestamp
        transaction.setPaymentStatus("Completed");  // Assuming the payment status is "Completed"
        transaction.setRemainingBalance(newRemainingBalance);  // Set the remaining balance after the payment
        transaction.setLoan(loan);  // Associate the transaction with the loan

        // Save the updated loan and the new transaction
        loanRepo.save(loan);
        transactionRepo.save(transaction);
    }

    // Fetches all transactions related to a specific loan
    public List<Transaction> getAllTransactionsByLoanId(Long loanId) {
        Loan loan = loanService.getLoanById(loanId);
        return loan.getTransactions();
    }

    public double calculateRemainingBalance(Long loanId) {
        Loan loan = loanService.getLoanById(loanId);
        return loan.getRemainingBalance();
    }
}
