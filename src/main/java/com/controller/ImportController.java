package com.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.model.ImportBill;
import com.model.ImportItem;
import com.model.Item;
import com.model.Supplier;
import com.service.ImportBillService;
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
    @Autowired
    private ImportBillService importBillService;

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
    @RequestMapping(value="/import-bill", method = RequestMethod.GET)
    public String showImportBill(ImportBill importBill, Model model,ImportItem importItem,HttpSession session) {
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

    @RequestMapping(value="/reciept", method=RequestMethod.POST)
    public String showreciept(@ModelAttribute("importItem") ImportItem importItem){
        System.out.println(importItem.toString());
        // importBillService.createImportBill(importBill);
        return "reciept";
    }
}