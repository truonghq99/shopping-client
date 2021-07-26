package com.service.serviceImpl;

import java.util.ArrayList;

import com.model.ImportBill;
import com.model.ImportItem;
import com.repository.ImportBillRepository;
import com.service.ImportBillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportBillServiceImpl implements ImportBillService {
    
    @Autowired
    private ImportBillRepository repo;

    @Override
    public void createImportBill (ImportBill importBill){
        repo.save(importBill);
    }

    @Override
    public void saveDetailImport(ArrayList<ImportItem> listImportItem){
        
    }
}
