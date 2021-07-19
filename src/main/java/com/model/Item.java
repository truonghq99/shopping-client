package com.model;

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
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Item")
public class Item implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected int id;
    @Column(name="title")
    protected String title;
    @Column(name="type")
    @Enumerated(EnumType.STRING)
    protected Type type;
    @Column(name="price")
    protected float price;
    @Column(name="mfgDate")
    protected Date mfgDate;

    public static enum Type{
        Book,Clothes,Electronics
    }
}
