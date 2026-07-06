package com.axsos.renderingallbooks.controllers;

import com.axsos.renderingallbooks.models.Book;
import com.axsos.renderingallbooks.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
// here for  returning an jsp file
@Controller
// this is the inital route and the main one
@RequestMapping("/")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
//    this is for returning jsp file for the index file
    @RequestMapping("")
    public String index(){
        return "index";
    }
//    here to show a book by its id
    @RequestMapping("books/{id}")
    public String show(@PathVariable("id")long id, Model model){
        Book book = bookService.findBook(id);
        model.addAttribute("book",book);
        return "index";
    }
//    here to show all books
    @RequestMapping("/books")
    public String showAllBooks(Model model){
        List<Book> book = bookService.allBooks();
        model.addAttribute("book",book);
        return "allbooks";
    }
}
