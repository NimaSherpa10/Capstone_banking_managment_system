package com.backend.bankingManagmentSystem.repo;

import com.backend.bankingManagmentSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
        User findByUserName(String username);
}
