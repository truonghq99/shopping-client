package com.repository;

import java.util.ArrayList;

import com.model.StoreItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreItemRepository extends JpaRepository<StoreItem, Integer>{
    
    ArrayList<StoreItem> findByStore(int id);
}
