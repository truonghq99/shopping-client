package com.service.serviceImpl;

import com.model.Electronics;
import com.repository.ElectronicsRepository;
import com.service.ElectronicsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectronicsServiceImpl  implements ElectronicsService{
    
    @Autowired
    private ElectronicsRepository repo;

    @Override
    public Electronics saveElectronics(Electronics Electronics){
        return repo.save(Electronics);
    }
}
