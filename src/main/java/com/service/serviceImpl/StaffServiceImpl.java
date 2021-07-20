package com.service.serviceImpl;

import java.util.List;

import com.model.Staff;
import com.repository.StaffRepository;
import com.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository repo;

    @Override
    public Staff createStaff(Staff staff) {
        return repo.saveAndFlush(staff);
    }

  
    @Override
    public List<Staff> getAllStaff() {
        return (List<Staff>) repo.findAll();
    }

    @Override
    public String checkLogin(String username, String password) {
        Staff staff = new Staff();
        staff=(Staff) repo.findStaffByUsername(username);
        if (password.equals(staff.getPassword())) {
            return "staff";
        }else{
            return "failed";
        }
    }

    @Override
    public Staff findById(int id){
        return repo.getById(id);
    }

}