package com.service.serviceImpl;

import com.model.Clothes;
import com.repository.ClothesRepository;
import com.service.ClothesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesServiceImpl  implements ClothesService{
    
    @Autowired
    private ClothesRepository repo;

    @Override
    public Clothes saveClothes(Clothes Clothes){
        return repo.save(Clothes);
    }
}
