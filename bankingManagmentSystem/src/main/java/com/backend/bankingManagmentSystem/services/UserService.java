package com.backend.bankingManagmentSystem.services;

import com.backend.bankingManagmentSystem.entity.User;
import com.backend.bankingManagmentSystem.model.UserDto;
import com.backend.bankingManagmentSystem.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager manager;
    //password encoder
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public User register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("Admin");
        System.out.println(user);
        return userRepo.save(user);
    }

    public String verifyUser(User user) {
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword())
        );
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName());
        }
        return "failed";
    }

    public User getUserById(Long userId) {

        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public void updateUserProfile(Long userId, User userDetails) {
        User user = getUserById(userId);
        user.setUserName(userDetails.getUserName());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        userRepo.delete(user);
    }

}
