package com.axsos.loginregistration.services;

import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User newUser, BindingResult result) {

        // Check whether the email is already in the database.
        if (!result.hasFieldErrors("email")) {
            Optional<User> existingUser =
                    userRepository.findByEmail(newUser.getEmail());

            if (existingUser.isPresent()) {
                result.rejectValue(
                        "email",
                        "Unique",
                        "This email is already registered."
                );
            }
        }

        // Check whether password and confirmation match.
        if (newUser.getPassword() != null
                && newUser.getConfirm() != null
                && !newUser.getPassword().equals(newUser.getConfirm())) {

            result.rejectValue(
                    "confirm",
                    "Matches",
                    "Password confirmation must match the password."
            );
        }

        if (result.hasErrors()) {
            return null;
        }

        // Never save the plain password.
        String hashedPassword =
                passwordEncoder.encode(newUser.getPassword());

        newUser.setPassword(hashedPassword);
        newUser.setConfirm(null);

        return userRepository.save(newUser);
    }

    public User login(LoginUser loginUser, BindingResult result) {

        // Stop before querying the database when basic fields are invalid.
        if (result.hasErrors()) {
            return null;
        }

        Optional<User> potentialUser =
                userRepository.findByEmail(loginUser.getEmail());

        if (potentialUser.isEmpty()) {
            result.rejectValue(
                    "email",
                    "NotFound",
                    "No account was found with this email."
            );
            return null;
        }

        User user = potentialUser.get();

        if (!passwordEncoder.matches(
                loginUser.getPassword(),
                user.getPassword()
        )) {
            result.rejectValue(
                    "password",
                    "Matches",
                    "Incorrect password."
            );
            return null;
        }

        return user;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
