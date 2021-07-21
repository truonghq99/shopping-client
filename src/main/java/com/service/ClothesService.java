package com.service;

import com.model.Clothes;

import org.springframework.stereotype.Service;

@Service
public interface ClothesService {
    
    public Clothes saveClothes(Clothes clothes);
}
