package com.service.serviceImpl;

import com.model.Fullname;
import com.repository.FullnameRepository;
import com.service.FullnameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullnameServiceImpl implements FullnameService {
    
    @Autowired
    private FullnameRepository repo;

    @Override
    public Fullname saveFullName(Fullname fullname) {
        return repo.saveAndFlush(fullname);
    }
}
