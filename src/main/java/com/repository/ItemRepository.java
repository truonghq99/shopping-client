package com.repository;


import com.model.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>, PagingAndSortingRepository<Item, Integer> {
    
    Page<Item> findAll(Pageable pageable);

    Page<Item> findByType(String type, Pageable pageable);

    Slice<Item> findByTitle(String title, Pageable pageable);
    
}
