package com.task.Library.Management.System.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false)
    private String information;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id")
    List<BorrowingRecord> borrowingRecords=new ArrayList<>();

    public Patron() {
    }

    public Patron(String name, String contact, String information) {
        this.name = name;
        this.contact = contact;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getInformation() {
        return information;
    }

    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setBorrowingRecords(List<BorrowingRecord> borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setName(String name) {
        this.name = name;
    }
}
