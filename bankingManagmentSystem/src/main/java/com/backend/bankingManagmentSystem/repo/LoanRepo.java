package com.backend.bankingManagmentSystem.repo;

import com.backend.bankingManagmentSystem.entity.Loan;
import com.backend.bankingManagmentSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {
    List<Loan> findByUser(User user);

    List<Loan> findByStatus(String status);
}
