package com.zaki.booksapi.controllers;

import com.zaki.booksapi.models.Book;
import com.zaki.booksapi.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) throws IOException {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
}
