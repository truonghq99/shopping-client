package com.service.serviceImpl;

import com.model.Address;
import com.repository.AddressRepository;
import com.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    
    @Autowired
    private AddressRepository repo;

    @Override
    public Address saveAddress(Address address){
        return repo.saveAndFlush(address);
    }

}
