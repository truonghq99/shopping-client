package com.controller;

import java.util.ArrayList;

import com.model.ImportBill;
import com.model.ImportItem;
import com.model.Item;
import com.model.Supplier;
import com.service.ItemService;
import com.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ImportController {
    
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ItemService itemService;

    //Form add supplier
    @RequestMapping(value="/home/create-supplier", method = RequestMethod.GET)
    public String showCreateSupplier(Supplier supplier, Model model){
        model.addAttribute("supplier", supplier);
        return "create_supplier.html";
    }

    //Save supplier
    @RequestMapping(value="/saveSupplier", method = RequestMethod.POST)
    public String saveSupplier(@ModelAttribute("supplier")Supplier supplier){
        supplierService.createSupplier(supplier);
        return "redirect:/home/create-supplier";
    }

    //Create Bill
    @RequestMapping(value="/home/import-bill", method = RequestMethod.GET)
    public String showImportBill(ImportBill importBill, Model model, Supplier supplier, Item item, ImportItem importItem){
        ArrayList<Supplier> listSupplier = new ArrayList<Supplier>();
        ArrayList<Item> listItem= new ArrayList<Item>();
        listSupplier= supplierService.findAll();
        listItem=itemService.findAll();
        model.addAttribute("listItem", listItem);
        model.addAttribute("listSupplier", listSupplier);
        model.addAttribute("importItem", importItem);
        model.addAttribute("bill", importBill);
        return "import_bill";

    }

}
