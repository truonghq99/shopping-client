package com.service.serviceImpl;
import org.springframework.stereotype.Service;

import com.model.Item;
import com.repository.ItemRepository;
import com.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ItemServiceImpl implements ItemService{
    
    @Autowired
    private ItemRepository repo;

    @Override
    public Item createItem(Item item){ 
        return repo.save(item);
    }

}
