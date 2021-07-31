package com.service.serviceImpl;
import java.util.ArrayList;

import com.model.StoreItem;
import com.repository.StoreItemRepository;
import com.service.StoreItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreItemServiceImpl implements StoreItemService {
    
    @Autowired
    private StoreItemRepository repo;

    @Override
    public ArrayList<StoreItem> getAllItemInStore(int id) {
        ArrayList<StoreItem> list= new ArrayList<StoreItem>();
        list=repo.findByStore(id);
        return list;
    }
}
