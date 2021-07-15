package com.member;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fullname.Fullname;
import com.address.Address;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Table(name = "member")
@NoArgsConstructor
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Please fill up the blank")
    private String username;
    @NotBlank(message = "Please fill up the blank")
    private String password;
    @OneToOne
    @JoinColumn(name = "fullname_id", nullable = false)
    private Fullname fullname;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    private Date dateOfBirth;
    private String phoneNumber;
    private String position;
    private String email;
    
}