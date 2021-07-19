package com.service;

import com.model.Fullname;

import org.springframework.stereotype.Service;

@Service
public interface FullnameService {
    
    Fullname saveFullName(Fullname fullname);
}
