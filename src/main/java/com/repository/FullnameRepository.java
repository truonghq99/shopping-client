package com.repository;

import com.model.Fullname;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullnameRepository extends JpaRepository<Fullname,Integer> {
    

}
