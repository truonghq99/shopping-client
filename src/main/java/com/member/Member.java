package com.member;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "Please fill up the blank")
    private String username;
    @NotBlank(message = "Please fill up the blank")
    private String password;
    private Date dateOfBirth;
    private String phoneNumber;
    private String position;
    private String email;
    
}