package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class StoreItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="item_id", referencedColumnName = "id")
    private Item item;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="store_id", referencedColumnName = "id")
    private Store store;
    private int quantity;
    private boolean active=false;
}
