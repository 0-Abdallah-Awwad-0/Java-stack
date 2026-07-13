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

        if (session.getAttribute("userId") != null) {
            return "redirect:/books";
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
            // Keep the login form available after registration errors.
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }

        // Automatically log in the newly registered user.
        session.setAttribute("userId", registeredUser.getId());

        return "redirect:/books";
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
            // Keep the registration form available after login errors.
            model.addAttribute("newUser", new User());
            return "index";
        }

        session.setAttribute("userId", loggedInUser.getId());

        return "redirect:/books";
    }

    @GetMapping("/success")
    public String oldSuccessRoute(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }

        return "redirect:/books";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
