package com.repository;

import com.model.Electronics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectronicsRepository extends JpaRepository<Electronics, Integer> {
    
}
