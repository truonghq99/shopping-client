package com.fullname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullnameServiceImpl implements FullnameService {
    
    @Autowired
    private FullnameRepository repo;

    @Override
    public Fullname saveFullName(Fullname fullname) {
        fullname= new Fullname();
        return repo.save(fullname);
    }
}
