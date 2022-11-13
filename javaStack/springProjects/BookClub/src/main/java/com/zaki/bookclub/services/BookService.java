package com.zaki.bookclub.services;

import com.zaki.bookclub.models.Book;
import com.zaki.bookclub.models.User;
import com.zaki.bookclub.repositories.BookRepository;
import com.zaki.bookclub.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    public List<Book> unBorrowedBooks(User user){
        return bookRepository.findByBorrowerIdIsOrUserIdIs(null, user.getId());
    }

    public List<Book> borrowedBooks(User user){
        return bookRepository.findByBorrowerIdIs(user.getId());
    }

    public void removeBorrower(Book book) {
        book.setBorrower(null);
        bookRepository.save(book);
    }

    public void addBorrower(Book book, User user) {
        book.setBorrower(user);
        bookRepository.save(book);
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


