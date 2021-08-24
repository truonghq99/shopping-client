package com.service;

import java.util.ArrayList;

import com.model.Item;

public interface ItemService {
    Item createItem(Item item);

    ArrayList<Item> findAll();

    void updateQuantityItemImport(int id , int quantity);

    boolean updateQuantityItemExport(int id , int quantity);
}
