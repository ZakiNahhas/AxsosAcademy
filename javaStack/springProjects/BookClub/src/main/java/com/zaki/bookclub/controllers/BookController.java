package com.zaki.bookclub.controllers;

import com.zaki.bookclub.models.Book;
import com.zaki.bookclub.models.LoginUser;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            return "redirect:/books";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        userService.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/books";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
        User user = userService.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/books";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }

    @GetMapping("/books")
    public String allBooks(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long user_id = (Long)session.getAttribute("user_id");
            User thisUser = userService.findUserById(user_id);
            model.addAttribute("thisUser", thisUser);
            List<Book> books = bookService.allBooks();
            model.addAttribute("books", books);

            return "allBooks.jsp";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long)session.getAttribute("user_id");
            User user = userService.findUserById(userId);
            model.addAttribute("user", userId);
            return "newBook.jsp";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/books/create")
    public String handleForm(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "newBook.jsp";
        } else {
            Long userId = (Long)session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            book.setUser(currentUser);
            bookService.createBook(book);
            return "redirect:/books";
        }
    }

    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Book book = bookService.findBook(id);
            model.addAttribute("book", book);
            return "edit.jsp";
        } else {
            return "redirect:/";
        }
    }

    @PutMapping(value = "/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            Long userId = (Long)session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            book.setUser(currentUser);
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    @PutMapping(value = "/books2/{id}")
    public String update2(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            Long userId = (Long)session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            book.setUser(currentUser);
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }

    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/bookmarketDel/{id}")
    public String destroy2(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/bookmarket";
    }
    @GetMapping("/bookmarket")
    public String bookmarket(HttpSession session, Model model) {

        Long userId = (Long) session.getAttribute("user_id");
//        if(userId == null) {
//            return "redirect:/logout";
//        }

        model.addAttribute("user", userService.findUserById(userId));

        List<Book> books = bookService.unBorrowedBooks(userService.findUserById(userId));
        model.addAttribute("books", books);

        List<Book> myBooks = bookService.borrowedBooks(userService.findUserById(userId));
        model.addAttribute("myBooks", myBooks);

        return "bookMarket.jsp";
    }

    @RequestMapping("/bookmarket/{bookID}")
    public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {

        Long userId = (Long) session.getAttribute("user_id");
        if(userId == null) {
            return "redirect:/logout";
        }
        bookService.addBorrower(bookService.findBook(bookID), userService.findUserById(userId));

        return "redirect:/bookmarket";
    }

    @RequestMapping("/bookmarket/return/{bookID}")
    public String returnBook(@PathVariable("bookID") Long bookID, HttpSession session) {

        if(session.getAttribute("user_id") == null) {
            return "redirect:/logout";
        }
        bookService.removeBorrower(bookService.findBook(bookID));

        return "redirect:/bookmarket";
    }

}
