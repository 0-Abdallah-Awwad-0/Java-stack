package com.axsos.renderingallbooks.controllers;

import com.axsos.renderingallbooks.models.Book;
import com.axsos.renderingallbooks.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//here is restcontroller cuz we dont need to return an jsp file
@RestController
public class BookApi {
//    here is the DI the declare the service for controller to use it methodes with declaring the final
//    of it and must be declared once and cannot be change later
    private final BookService bookService;

    public BookApi(BookService bookService){
        this.bookService=bookService;
    }
//    here is for getting all books by listing them to a list
    @RequestMapping("/api/books")
    public List<Book> index(){
        return bookService.allBooks();
    }
//    here for creating a book
    @PostMapping("/api/books")
        public Book create(
                @RequestParam(value = "title") String  title,
                @RequestParam(value = "description")String description,
                @RequestParam(value = "language") String language,
                @RequestParam(value = "numberOfPages")int numberOfPages
    ){
        Book book = new Book(title,description,language,numberOfPages);
        return bookService.createBook(book);
    }
//    here to get an book by its id and show it with get request
    @RequestMapping("api/books/{id}")
    public Book show(@PathVariable("id") long id){
        return bookService.findBook(id);
    }
//    here with a put request we can update a book
    @RequestMapping(value = "api/books/{id}",method = RequestMethod.PUT)
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam(value = "title") String  title,
            @RequestParam(value = "description")String description,
            @RequestParam(value = "language") String language,
            @RequestParam(value = "numberOfPages")int numberOfPages
    ){
        return bookService.updateBook(id,title,description,language,numberOfPages);
    }
//    here for deleting a book
    @RequestMapping(value = "api/books/{id}",method = RequestMethod.DELETE)
    public void delete(
            @PathVariable("id")Long id
    ){
         bookService.deleteBook(id);
    }

}
