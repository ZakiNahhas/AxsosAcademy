package com.zaki.booksapi.controllers;

import com.zaki.booksapi.models.Book;
import com.zaki.booksapi.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;

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
    @RequestMapping("/books")
    public String allBooks(Model model) {
        ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
        model.addAttribute("books", books);

        return "allBooks.jsp";
    }
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "newBook.jsp";
    }
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String handleForm(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "newBook.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            bookService.updateBook(book);
        return "redirect:/books";
    }
        }
    }
