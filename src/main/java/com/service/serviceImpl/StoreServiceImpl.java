package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import com.model.Store;
import com.repository.StoreRepository;
import com.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
    
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store createStore(Store store){
        return storeRepository.save(store);
    }
    @Override
    public ArrayList<Store> findAllStore(){
        ArrayList<Store> list= new ArrayList<Store>();
        list= (ArrayList<Store>) storeRepository.findAll();
        return list;
    }

    @Override
    public void DeleteStore(int id){
        storeRepository.deleteById(id);
    }

    @Override
    public void UpdateStore(Store store,int id){
        Store t= storeRepository.findStoreById(id);
        t.setAddress(store.getAddress());
        t.setOpenDate(store.getOpenDate());
        t.setPhoneNumber(store.getPhoneNumber());
        storeRepository.save(t);
    }
}
