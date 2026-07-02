package com.axsosacademy.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsosacademy.mvc.models.Book;
import com.axsosacademy.mvc.services.BookService;

@RestController
public class BooksApi {

    private final BookService bookService;


    // Constructor injection
    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }


    // Get all books
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }


    // Create a new book
    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book create(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "description") String desc,
            @RequestParam(value = "language") String lang,
            @RequestParam(value = "pages") Integer numOfPages) {

        Book book = new Book(title, desc, lang, numOfPages);

        return bookService.createBook(book);
    }


    // Get one book by id
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        return bookService.findBook(id);
    }


    // Update an existing book
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "description") String desc,
            @RequestParam(value = "language") String lang,
            @RequestParam(value = "pages") Integer numOfPages) {

        return bookService.updateBook(id, title, desc, lang, numOfPages);
    }


    // Delete a book by id
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

}