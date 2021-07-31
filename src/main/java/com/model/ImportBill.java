package com.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ImportBill implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idBill;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="supplier_id",referencedColumnName = "id")
    private Supplier supplier;
    private Date date;
    private float price;
    private float discount;
    private float totalPrice;

    @OneToMany(mappedBy="importBill",cascade = CascadeType.ALL)
    private List<ImportItem> importItem=new ArrayList<>();

    public void addImportItem(ImportItem importItem) {
        this.getImportItem().add(importItem);
    }
}
