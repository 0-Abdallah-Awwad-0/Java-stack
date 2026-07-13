package com.axsos.loginregistration.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final com.axsos.loginregistration.services.PasswordService passwordService;

    public UserService(UserRepository userRepo, com.axsos.loginregistration.services.PasswordService passwordService) {
        this.userRepo = userRepo;
        this.passwordService = passwordService;
    }

    public User register(User newUser, BindingResult result) {

        Optional<User> possibleUser = userRepo.findByEmail(newUser.getEmail());

        if (possibleUser.isPresent()) {
            result.rejectValue("email", "Unique", "Email already exists");
        }

        if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "Match", "Passwords do not match");
        }

        if (result.hasErrors()) {
            return null;
        }

        String salt = passwordService.generateSalt();
        String hashedPassword = passwordService.hashPassword(newUser.getPassword(), salt);

        newUser.setSalt(salt);
        newUser.setPassword(hashedPassword);

        return userRepo.save(newUser);
    }

    public User login(LoginUser loginUser, BindingResult result) {

        Optional<User> possibleUser = userRepo.findByEmail(loginUser.getEmail());

        if (possibleUser.isEmpty()) {
            result.rejectValue("email", "NotFound", "Email not found");
            return null;
        }

        User user = possibleUser.get();

        String hashedInput = passwordService.hashPassword(
                loginUser.getPassword(),
                user.getSalt()
        );

        if (!hashedInput.equals(user.getPassword())) {
            result.rejectValue("password", "Invalid", "Invalid password");
        }

        if (result.hasErrors()) {
            return null;
        }

        return user;
    }
}