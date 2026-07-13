package com.axsos.loginregistration.repositories;

import com.axsos.loginregistration.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAllByOrderByCreatedAtDesc();
}
