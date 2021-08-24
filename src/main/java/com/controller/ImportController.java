package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImportController {

	@Autowired
	private SupplierService supplierService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ImportBillService importBillService;

	// Form add supplier
	@RequestMapping(value = "/home/create-supplier", method = RequestMethod.GET)
	public String showCreateSupplier(Supplier supplier, Model model) {
		model.addAttribute("supplier", supplier);
		return "create_supplier.html";
	}

	// Save supplier
	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST)
	public String saveSupplier(@ModelAttribute("supplier") Supplier supplier) {
		supplierService.createSupplier(supplier);
		return "redirect:/home/create-supplier";
	}

	// Create Bill
	@RequestMapping(value = "/import-bill", method = RequestMethod.GET)
	public String showImportBill(ImportBill importBill, Model model) { // dung requestparam
		ArrayList<Item> items= itemService.findAll();
		ArrayList<Supplier> suppliers = supplierService.findAll();
		for(int i=0;i<items.size();i++){
			ImportItem importItem = new ImportItem();
			importItem.setItem(items.get(i));
			importBill.getListImportItem().add(importItem);
		}
		model.addAttribute("listSupplier", suppliers);
		model.addAttribute("importBill", importBill);
		return "import_bill";
	}

	@RequestMapping(value="/reciept" , method = RequestMethod.POST)
    public String saveReciept(ImportBill reciept) {
        SimpleDateFormat sdf= new SimpleDateFormat("yyMMddhhmmssMs");
        Date date= new Date();
        String idBill= sdf.format(date);
        reciept.setIdBill(idBill);
		
        for(int i=0;i<reciept.getListImportItem().size();i++) {
            if (reciept.getListImportItem().get(i).getTotalPriceItem() <= 0.0) {
                reciept.getListImportItem().remove(i);
                i--;
            }else{
			System.out.println(reciept.getListImportItem().get(i).getItem());
			itemService.updateQuantityItem(
				reciept.getListImportItem().get(i).getItem().getId(),
				reciept.getListImportItem().get(i).getQuantity());
			}
        }
        // importBillService.createImportBill(reciept);
        return "home_page";
    }

}