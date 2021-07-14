package com.member;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.account.Account;
import com.fullname.Fullname;
import com.address.Address;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="member")
@RequiredArgsConstructor
public class Member implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name="id", nullable=false)
    private Account account;
    @OneToOne
    @JoinColumn(name="id", nullable=false)
    private Fullname fullname;
    @OneToOne
    @JoinColumn(name="id", nullable=false)
    private Address address;
    private Date dateOfBirth;
    private String phoneNumber;
    private String position;
}