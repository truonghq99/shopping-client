package com.item;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="Item")
public class Item implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="type")
    @Enumerated(EnumType.STRING) 
    private Type type;
    @Column(name="price")
    private float price;
    @Column(name="mfgDate")
    private Date mfgDate;

    public static enum Type{
        Book,Clothes,Electronics
    }
}
