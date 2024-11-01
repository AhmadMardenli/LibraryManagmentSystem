package com.task.Library.Management.System.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "book_id",nullable = false)
    private long book_id;
    @Column(name = "patron_id",nullable = false)
    private long patron_id;
    private Date borrow_date;
    @Column(nullable = false)
    private Date return_date;

    public BorrowingRecord(long book_id, long patron_id, Date borrow_date) {
        this.book_id = book_id;
        this.patron_id = patron_id;
        this.borrow_date = borrow_date;
    }

    public BorrowingRecord() {
    }

    public long getBook_id() {
        return book_id;
    }

    public long getPatron_id() {
        return patron_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
