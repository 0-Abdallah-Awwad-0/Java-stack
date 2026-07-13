package com.axsos.loginregistration.controllers;

import com.axsos.loginregistration.models.Book;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.services.BookService;
import com.axsos.loginregistration.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BookController {

    private final BookService bookService;
    private final UserService userService;

    public BookController(
            BookService bookService,
            UserService userService
    ) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/books")
    public String books(HttpSession session, Model model) {

        User loggedInUser = getLoggedInUser(session);

        if (loggedInUser == null) {
            return "redirect:/";
        }

        model.addAttribute("loggedInUser", loggedInUser);
        model.addAttribute("books", bookService.findAll());

        return "books";
    }

    @GetMapping("/books/new")
    public String newBook(
            HttpSession session,
            Model model
    ) {
        if (getLoggedInUser(session) == null) {
            return "redirect:/";
        }

        model.addAttribute("book", new Book());

        return "newBook";
    }

    @PostMapping("/books")
    public String createBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult result,
            HttpSession session
    ) {
        User loggedInUser = getLoggedInUser(session);

        if (loggedInUser == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            return "newBook";
        }

        // Connect the new book to the logged-in user.
        book.setUser(loggedInUser);
        bookService.create(book);

        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public String showBook(
            @PathVariable("id") Long id,
            HttpSession session,
            Model model
    ) {
        User loggedInUser = getLoggedInUser(session);

        if (loggedInUser == null) {
            return "redirect:/";
        }

        Book book = bookService.findById(id);

        if (book == null) {
            return "redirect:/books";
        }

        model.addAttribute("book", book);
        model.addAttribute("loggedInUser", loggedInUser);

        return "bookDetails";
    }

    @GetMapping("/books/{id}/edit")
    public String editBook(
            @PathVariable("id") Long id,
            HttpSession session,
            Model model
    ) {
        Long userId = getSessionUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Book book = bookService.findById(id);

        // Only the book's owner can open the edit page.
        if (!bookService.isOwner(book, userId)) {
            return "redirect:/books";
        }

        model.addAttribute("book", book);

        return "editBook";
    }

    @PutMapping("/books/{id}")
    public String updateBook(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("book") Book formBook,
            BindingResult result,
            HttpSession session
    ) {
        Long userId = getSessionUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Book existingBook = bookService.findById(id);

        // Server-level ownership protection.
        if (!bookService.isOwner(existingBook, userId)) {
            return "redirect:/books";
        }

        if (result.hasErrors()) {
            return "editBook";
        }

        bookService.update(existingBook, formBook);

        return "redirect:/books/" + id;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(
            @PathVariable("id") Long id,
            HttpSession session
    ) {
        Long userId = getSessionUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Book book = bookService.findById(id);

        // Server-level ownership protection.
        if (bookService.isOwner(book, userId)) {
            bookService.delete(book);
        }

        return "redirect:/books";
    }

    private Long getSessionUserId(HttpSession session) {
        return (Long) session.getAttribute("userId");
    }

    private User getLoggedInUser(HttpSession session) {
        Long userId = getSessionUserId(session);

        if (userId == null) {
            return null;
        }

        User user = userService.findById(userId);

        if (user == null) {
            session.invalidate();
        }

        return user;
    }
}
