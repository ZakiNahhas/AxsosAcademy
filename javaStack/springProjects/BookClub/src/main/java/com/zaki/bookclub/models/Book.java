package com.zaki.bookclub.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    @NotNull
    @Size(min = 5, max = 200, message = "Title should be more than 5 and less than 200 baby")
    private String title;
    @NotNull
    @Size(min = 5, max = 200)
    private String myThoughts;
    @NotNull
    @Size(min = 3, max = 40)
    private String author;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User   user;

    public Book() {
    }

    public Book(Long id, String title, String myThoughts, String author, Date createdAt, Date updatedAt, User user) {
        this.id = id;
        this.title = title;
        this.myThoughts = myThoughts;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
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
