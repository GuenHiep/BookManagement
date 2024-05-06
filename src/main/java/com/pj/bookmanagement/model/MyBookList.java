package com.pj.bookmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="MyBooks")
@Data
public class MyBookList {

    @Id
    private int id;
    private String name;
    private String author;
    private String price;

    public MyBookList() {}

    public MyBookList(int id, String name, String author, String price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }
}