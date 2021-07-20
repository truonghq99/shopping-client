package com.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("clothes")
public class Clothes extends Item{
    @Column(name="size")
    private String size;
    @Column(name="material")
    private String material;
}
