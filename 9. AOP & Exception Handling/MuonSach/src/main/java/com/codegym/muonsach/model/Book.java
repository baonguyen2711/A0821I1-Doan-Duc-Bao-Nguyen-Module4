package com.codegym.muonsach.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBook;
    private int amount;

    public Book() {
    }

    public Book(int Integer, String nameBook, int amount) {
        this.id = id;
        this.nameBook = nameBook;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
