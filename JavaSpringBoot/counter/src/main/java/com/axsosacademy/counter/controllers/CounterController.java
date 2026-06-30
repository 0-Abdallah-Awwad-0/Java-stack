package com.axsosacademy.counter.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    @GetMapping("/")
    public String index(HttpSession session) {

        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 0;
        }

        count++;

        session.setAttribute("count", count);

        return "You visited the home page. The counter increased by 1.";
    }


    @GetMapping("/counter")
    public String counter(HttpSession session) {

        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 0;
        }

        return "You have visited the home page " + count + " time(s).";
    }

}