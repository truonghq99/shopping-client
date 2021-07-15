package com.fullname;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullnameRepository extends JpaRepository<Fullname,Integer> {
    

}
