package com.zaki.bookclub.controllers;

import com.zaki.bookclub.models.Book;
import com.zaki.bookclub.models.User;
import com.zaki.bookclub.services.BookService;
import com.zaki.bookclub.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @RequestMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }

    @RequestMapping("/books")
    public String allBooks(Model model, HttpSession session) {
        ArrayList<Book> books = (ArrayList<Book>)bookService.allBooks();
        model.addAttribute("books", books);
        if (session.getAttribute("user_id") != null) {
            Long user_id = (Long)session.getAttribute("user_id");
            User thisUser = userService.findUserById(user_id);
            model.addAttribute("thisUser", thisUser);
            return "allBooks.jsp";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "newBook.jsp";
    }

    @RequestMapping(value = "/books/create", method = RequestMethod.POST)
    public String handleForm(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "newBook.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
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

    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }

    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
