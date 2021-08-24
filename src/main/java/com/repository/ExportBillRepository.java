package com.repository;

import com.model.ExportBill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportBillRepository extends JpaRepository<ExportBill, Integer> {
    
}
