package com.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Item")	
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "title")
    protected String title;
    @Column(name = "type", insertable = false, updatable = false)
    protected String type;
    @Column(name = "price")
    protected float price;

    private int quantity=0;
   
    @Column(name = "mfgDate")
    protected Date mfgDate;
    protected boolean active=false;

    @OneToOne(mappedBy="item", cascade = CascadeType.ALL)
    private ImportItem importItem;
    
    @OneToMany(mappedBy="item", cascade = CascadeType.ALL)
    private List<StoreItem> storeItem = new ArrayList<>();

    @Transient
	private MultipartFile bookImage;
}
