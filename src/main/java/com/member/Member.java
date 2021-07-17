package com.member;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.address.Address;
import com.fullname.Fullname;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "member")
@NoArgsConstructor
public class Member implements Serializable {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private Date dateOfBirth;
    private String phoneNumber;
    private String position;
    private String email;

    @OneToOne(mappedBy="memberId")
    private Fullname fullname;

    @OneToOne(mappedBy="memberId")
    private Address address;

}