package com.zaki.exam.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username is required!")
    @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters")
    private String userName;

    @NotEmpty(message = "Email is required!")
    @Email(message = "Please enter a valid email!")
    private String email;

    @NotEmpty(message = "Password is required!")
    @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
    private String password;

    @Transient
    @NotEmpty(message = "Confirm Password is required!")
    @Size(min = 8, max = 128, message = "Passwords must match")
    private String confirm;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   updatedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Book> books;

    @Column(updatable = false)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Book> borrowedBooks;

    public User() {
    }

    public User(Long id, String userName, String email, String password, String confirm, Date createdAt, Date updatedAt, List<Book> books) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.books = books;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
