package com.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController{
    @Autowired
    private ItemService service;

    @GetMapping("/createItem")
    public String showCreateItem(Model model){
        Item item= new Item();
        model.addAttribute("item", item);
        return "createItem";
    }
    @RequestMapping(value="/createItem", method = RequestMethod.POST)
    public Item saveItem(@Validated @RequestBody Item item){
        return service.createItem(item);
    }
    

}