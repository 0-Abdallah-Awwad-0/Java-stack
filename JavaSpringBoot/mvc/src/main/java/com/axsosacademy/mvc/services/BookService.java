package com.axsosacademy.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsosacademy.mvc.models.Book;
import com.axsosacademy.mvc.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;


    // Constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // Get all books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }


    // Create a new book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }


    // Find one book by id
    public Book findBook(Long id) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }


    // Update an existing book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {

        Book book = bookRepository.findById(id).orElse(null);

        if (book == null) {
            return null;
        }

        book.setTitle(title);
        book.setDescription(desc);
        book.setLanguage(lang);
        book.setPages(numOfPages);

        return bookRepository.save(book);
    }


    // Delete a book by id
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}