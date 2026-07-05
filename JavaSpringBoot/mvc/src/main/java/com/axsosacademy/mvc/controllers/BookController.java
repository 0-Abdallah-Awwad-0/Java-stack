package com.axsosacademy.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.axsosacademy.mvc.models.Book;
import com.axsosacademy.mvc.services.BookService;

@Controller
public class BookController {

    private final BookService bookService;

    // Constructor injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Show one book page
    @GetMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {

        Book book = bookService.findBook(id);

        // Send the book object to show.jsp
        model.addAttribute("book", book);

        return "show";
    }
}