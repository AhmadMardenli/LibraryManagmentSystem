package com.task.Library.Management.System.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    private int publication_year;
    @Column(nullable = false)
    private String isbn;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    List<BorrowingRecord> borrowingRecords=new ArrayList<>();
    public Book() {
    }

    public Book(String title, String author, int publication_year, String isbn) {
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setBorrowingRecords(List<BorrowingRecord> borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }
}
