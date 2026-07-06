package com.axsos.renderingallbooks.services;

import com.axsos.renderingallbooks.models.Book;
import com.axsos.renderingallbooks.repositires.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// we declare and said to the spring runtime this is a service class and we need to work like a it holding bussins logic
@Service
public class BookService {
//    here we use the DI which we declare the book repo so we can use it method to the givin var
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    };
// here we use find all to get all books to the list we create
    public List<Book> allBooks(){
        return bookRepository.findAll();
    }
//     here we use the save to INSERT a book
    public Book createBook(Book b){
        return bookRepository.save(b);
    }
    public Book findBook(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }else {
            return null;
        }

    }
    //     here we use the save to UPDATE a book

    public Book updateBook(Long id , String title,String description, String language,int numberOfPages){
        Book book = findBook(id);
        book.setTitle(title);
        book.setDescription(description);
        book.setLanguage(language);
        book.setNumberOfPages(numberOfPages);
        return bookRepository.save(book);
    }
//    and here the delete
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
