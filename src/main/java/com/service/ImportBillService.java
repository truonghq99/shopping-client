package com.service;

import java.util.ArrayList;

import com.model.ImportBill;
import com.model.ImportItem;

import org.springframework.stereotype.Service;

@Service
public interface ImportBillService {
    
    void createImportBill(ImportBill importBill);

    void saveDetailImport(ArrayList<ImportItem> listImportItem);
}
