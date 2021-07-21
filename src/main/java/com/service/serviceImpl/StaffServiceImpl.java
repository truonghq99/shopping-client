package com.service.serviceImpl;

import java.util.List;


import com.model.Staff;
import com.repository.StaffRepository;
import com.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService{

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

    // @Override
    // public UserDetails loadUserByUsername(String username) {
    //     // Kiểm tra xem user có tồn tại trong database không?
    //     Staff staff = (Staff) repo.findStaffByUsername(username);
    //     if (staff == null) {
    //         throw new UsernameNotFoundException(username);
    //     }
    //     return new CustomStaffDetails(staff);
    // }

    @Override
    public Staff findById(int id){
        return repo.getById(id);
    }

    @Override
    public boolean checkLogin(String username, String password){
        Staff staff= (Staff) repo.findStaffByUsername(username);
        if(password.equals(staff.getPassword())){
            return true;
        }
        return false;
    }

}