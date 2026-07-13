package com.axsos.loginregistration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("newUser") User newUser,
            BindingResult result,
            Model model,
            HttpSession session
    ) {
        User user = userService.register(newUser, result);

        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }

        session.setAttribute("userId", user.getId());

        return "redirect:/success";
    }

    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("newLogin") LoginUser loginUser,
            BindingResult result,
            Model model,
            HttpSession session
    ) {
        User user = userService.login(loginUser, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }

        session.setAttribute("userId", user.getId());

        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success(HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }

        return "success.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}