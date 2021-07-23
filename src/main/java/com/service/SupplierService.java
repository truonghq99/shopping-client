package com.service;

import java.util.ArrayList;

import com.model.Supplier;

import org.springframework.stereotype.Service;

@Service
public interface SupplierService {
    
    public Supplier createSupplier(Supplier supplier);

    public ArrayList<Supplier> findAll();
}
