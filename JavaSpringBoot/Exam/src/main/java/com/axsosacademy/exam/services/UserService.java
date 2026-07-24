package com.axsosacademy.exam.services;


import java.util.Optional;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


import com.axsosacademy.exam.models.LoginUser;
import com.axsosacademy.exam.models.User;
import com.axsosacademy.exam.repositories.UserRepository;

@Service
public class UserService {


    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User newUser, BindingResult result) {
        Optional<User> existingUser = userRepository.findByEmail(newUser.getEmail());

        if (existingUser.isPresent()) {
            result.rejectValue("email", "Unique", "This email is already registered");
        }

        if (newUser.getPassword() != null && !newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "Passwords must match");
        }


        if (result.hasErrors()) {
            return null;
        }


        String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPassword);
        return userRepository.save(newUser);
    }



    public User login(LoginUser loginUser, BindingResult result) {
        Optional<User> potentialUser = userRepository.findByEmail(loginUser.getEmail());

        if (potentialUser.isEmpty()) {
            result.rejectValue("email", "NotFound", "Email not found");
            return null;
        }

        User user = potentialUser.get();
        if (!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid password");
            return null;
        }

        return user;
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
