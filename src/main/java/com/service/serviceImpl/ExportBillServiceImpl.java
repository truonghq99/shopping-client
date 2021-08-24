package com.service.serviceImpl;

import java.util.ArrayList;

import com.model.ExportBill;
import com.repository.ExportBillRepository;
import com.service.ExportBillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportBillServiceImpl implements ExportBillService {

    @Autowired
    private ExportBillRepository exportBillRepository;

    @Override
    public ExportBill createExportBill(ExportBill exportBill) {
        return exportBillRepository.save(exportBill);
    }

    @Override
    public ArrayList<ExportBill> getAll() {
        return (ArrayList<ExportBill>) exportBillRepository.findAll();
    }

   
    
}
