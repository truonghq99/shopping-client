package com.service;

import com.model.ImportBill;

import org.springframework.stereotype.Service;

@Service
public interface ImportBillService {
    
    ImportBill createImportBill(ImportBill importBill);
}
