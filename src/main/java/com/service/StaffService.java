package com.service;



import java.util.List;
import com.model.Staff;


public interface StaffService {

    Staff createStaff(Staff staff);

    Staff findById(int id);

    List<Staff> getAllStaff();

    String checkLogin(String username,String password);
}
