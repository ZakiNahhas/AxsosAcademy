package com.zaki.bookclub.repositories;

import com.zaki.bookclub.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findByBorrowerIdIs(Long userId);
    List<Book> findByBorrowerIdIsOrUserIdIs(Long borrowerID, Long userId);

//    List<Book> findByDescriptionContaining(String search);
//
//    Long countByTitleContaining(String search);
//
//    Long deleteByTitleStartingWith(String search);
}

