package com.service;

import com.model.Electronics;

import org.springframework.stereotype.Service;

@Service
public interface ElectronicsService {
    
    public Electronics saveElectronics(Electronics electronics);
}
