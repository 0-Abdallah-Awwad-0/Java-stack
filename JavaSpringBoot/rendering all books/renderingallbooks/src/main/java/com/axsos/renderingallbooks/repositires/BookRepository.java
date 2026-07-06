package com.axsos.renderingallbooks.repositires;

import com.axsos.renderingallbooks.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
//    here is an impementing method we take it and use it to get all books to the list
    List<Book> findAll();
}
