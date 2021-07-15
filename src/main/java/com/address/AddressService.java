package com.address;

import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    
    Address saveAddress(Address address);
}
