package com.service;

import com.model.Address;

import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    
    Address saveAddress(Address address);
}
