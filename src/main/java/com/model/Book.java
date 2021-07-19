package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;





@Entity
public class Book extends Item{
    @Column(name="author")
    private String author;
    @Column(name="publisher")
    private String publisher;


}
