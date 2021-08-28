package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Order_Details")
public class OrderDetail implements Serializable {
 
    private static final long serialVersionUID = 7550745928843183535L;
 
    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    private Order order;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private StoreItem storeItem;
 
    @Column(name = "Quanity", nullable = false)
    private int quanity;
 
    @Column(name = "Price", nullable = false)
    private double price;
 
    @Column(name = "Amount", nullable = false)
    private double amount;
}
 