package com.zaki.bookclub.services;

import com.zaki.bookclub.models.Book;
import com.zaki.bookclub.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public Book updateBook(Book b) {
        return bookRepository.save(b);
    }

    public void deleteBook(Long id) {
        Optional<Book> op = bookRepository.findById(id);
        if (op.isPresent()) {
            bookRepository.deleteById(id);
        }
    }
}


