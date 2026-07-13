package com.axsos.loginregistration.controllers;

import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {

        // An already logged-in user goes directly to success.
        if (session.getAttribute("userId") != null) {
            return "redirect:/success";
        }

        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "index";
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("newUser") User newUser,
            BindingResult result,
            Model model,
            HttpSession session
    ) {
        User registeredUser = userService.register(newUser, result);

        if (result.hasErrors()) {
            // This keeps both forms available after an error.
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }

        // Automatically log in the newly registered user.
        session.setAttribute("userId", registeredUser.getId());

        return "redirect:/success";
    }

    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("newLogin") LoginUser newLogin,
            BindingResult result,
            Model model,
            HttpSession session
    ) {
        User loggedInUser = userService.login(newLogin, result);

        if (result.hasErrors()) {
            // This keeps both forms available after an error.
            model.addAttribute("newUser", new User());
            return "index";
        }

        session.setAttribute("userId", loggedInUser.getId());

        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success(HttpSession session, Model model) {

        Long userId = (Long) session.getAttribute("userId");

        // Protect this route from users who are not logged in.
        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findById(userId);

        // Also protect against an invalid or deleted user ID.
        if (user == null) {
            session.invalidate();
            return "redirect:/";
        }

        model.addAttribute("user", user);

        return "success";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        // Remove the complete session.
        session.invalidate();

        return "redirect:/";
    }
}
