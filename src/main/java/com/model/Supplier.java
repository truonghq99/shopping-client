package com.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class Supplier implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String company;
    private String address;
    private Date cooperationDate;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private Collection<ImportBill> importBill;
}
