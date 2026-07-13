package com.axsos.loginregistration.services;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return Base64.getEncoder().encodeToString(salt);
    }

    public String hashPassword(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            String passwordWithSalt = password + salt;

            byte[] hashBytes = digest.digest(passwordWithSalt.getBytes());

            return Base64.getEncoder().encodeToString(hashBytes);

        } catch (Exception e) {
            throw new RuntimeException("Hashing failed");
        }
    }
}