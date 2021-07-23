package com.service.serviceImpl;

import java.util.ArrayList;

import com.model.Supplier;
import com.repository.SupplierRepository;
import com.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService{
    
    @Autowired
    private SupplierRepository repo;

    @Override
    public Supplier createSupplier(Supplier supplier){
        return repo.save(supplier);
    }

    @Override
    public ArrayList<Supplier> findAll(){
        ArrayList<Supplier> list = new ArrayList<Supplier>();
        list=(ArrayList<Supplier>) repo.findAll();
        return list;
    }
}
