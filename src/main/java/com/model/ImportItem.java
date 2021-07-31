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
public class ImportItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity=0;
    private float amount=0;
    private float discount=0;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="item_id",referencedColumnName = "id")
    private Item item;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="bill_id",referencedColumnName = "id")
    private ImportBill importBill;
    private float totalPrice=0;
	
    
}