package com.axsos.loginregistration.services;

import com.axsos.loginregistration.models.Book;
import com.axsos.loginregistration.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAllByOrderByCreatedAtDesc();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(
            Book existingBook,
            Book formBook
    ) {
        existingBook.setTitle(formBook.getTitle());
        existingBook.setAuthor(formBook.getAuthor());
        existingBook.setDescription(formBook.getDescription());

        return bookRepository.save(existingBook);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public boolean isOwner(Book book, Long userId) {
        return book != null
                && book.getUser() != null
                && book.getUser().getId().equals(userId);
    }
}
