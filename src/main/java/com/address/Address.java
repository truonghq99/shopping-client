package com.address;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.member.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="address")
@AllArgsConstructor
@NoArgsConstructor
public class Address{

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String street;
    private String district;
    private String city;
    private String state;
    private String country;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="member_id",referencedColumnName = "id" ,nullable = false)
    private Member memberId;
}