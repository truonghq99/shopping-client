package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name="orders", uniqueConstraints = {@UniqueConstraint(columnNames="Order_Num")})
public class Order implements Serializable {

    @Id
    private String id;

    private Date orderDate;

    @Column(name="Order_Num", nullable = false)
    private int orderNum;

    private double amount;

    private float discount;

    private double totalAmount;

    @ManyToOne
    private Member member;

    private String address;
    
}
