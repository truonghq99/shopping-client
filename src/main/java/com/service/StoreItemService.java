package com.service;

import java.util.ArrayList;

import com.model.StoreItem;

import org.springframework.stereotype.Service;

@Service
public interface StoreItemService {
    
    ArrayList<StoreItem> getAllItemInStore(int id);
}
