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
import com.fullname.Fullname;
import com.address.Address;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Table(name = "member")
@NoArgsConstructor
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Please fill up the blank")
    private String username;
    @NotBlank(message = "Please fill up the blank")
    private String password;
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Fullname fullname;
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Address address;
    private Date dateOfBirth;
    private String phoneNumber;
    private String position;
    private String email;
    
}