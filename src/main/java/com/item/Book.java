package com.item;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Book extends Item implements Serializable{
    @Column(name="author")
    private String author;
    @Column(name="publisher")
    private String publisher;


    public Book(int id,String title,Type type,float price,String mfgDate, String author, String publisher){
        this.id = id;
        this.title=title;
        this.type = type;
        this.price=price;
        this.mfgDate = mfgDate;
        this.author=author;
        this.publisher=publisher;
    }
}
