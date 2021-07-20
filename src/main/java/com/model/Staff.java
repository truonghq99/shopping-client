package com.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("staff")
public class Staff extends Member {
    @Column(name="position", updatable=false, insertable=false)
    private String position;
    
}
