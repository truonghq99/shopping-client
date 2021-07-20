package com.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "member")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="position", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("client")
public class Member implements Serializable {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable=false, unique = true)
    private String username;
    private String password;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fullname_id",referencedColumnName = "id" ,nullable = true)
    private Fullname fullnameId;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id",referencedColumnName = "id" ,nullable = true)
    private Address addressId;
}