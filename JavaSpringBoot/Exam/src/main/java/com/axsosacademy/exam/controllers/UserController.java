package com.axsosacademy.exam.controllers;

import com.axsosacademy.exam.models.User;
import com.axsosacademy.exam.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //profile page
    @GetMapping("/users/{id}")
    public String profile(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("userId") == null)
            return "redirect:/";

        User user = userService.findUser(id);
        if (user == null)
            return "redirect:/projects";

        model.addAttribute("profileUser", user);
        return "profile.jsp";

    }
}
