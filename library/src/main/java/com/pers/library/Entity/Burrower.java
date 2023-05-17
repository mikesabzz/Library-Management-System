package com.pers.library.Entity;
import javax.persistence.*;

@Entity
public class Burrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Burrower() {
        // Default constructor
    }

    public Burrower(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
