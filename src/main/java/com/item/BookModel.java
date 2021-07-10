package com.item;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class BookModel extends Item {
    @Column(name="author")
    private String author;
    @Column(name="publisher")
    private String publisher;
}
