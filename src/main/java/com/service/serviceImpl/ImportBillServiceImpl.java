package com.service.serviceImpl;

import com.model.ImportBill;
import com.repository.ImportBillRepository;
import com.service.ImportBillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportBillServiceImpl implements ImportBillService {
    
    @Autowired
    private ImportBillRepository repo;

    @Override
    public ImportBill createImportBill (ImportBill importBill){
        return repo.save(importBill);
    }
}
