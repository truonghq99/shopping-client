package com.service.serviceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    @Override
    public ArrayList<Item> findAll(){
        ArrayList<Item> list = new ArrayList<Item>();
        list=(ArrayList<Item>) repo.findAll();
        return list;
    }

}
