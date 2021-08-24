package com.service;

import java.util.ArrayList;

import com.model.ExportBill;

import org.springframework.stereotype.Service;

@Service
public interface ExportBillService {
    
    ExportBill createExportBill(ExportBill exportBill);

    ArrayList<ExportBill> getAll();
}
