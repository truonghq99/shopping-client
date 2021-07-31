package com.model;

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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String phoneNumber;
    private Date openDate;
    private String status;

    @OneToMany(mappedBy="store", cascade = CascadeType.ALL)
    private Collection<StoreItem> storeItem;
}
