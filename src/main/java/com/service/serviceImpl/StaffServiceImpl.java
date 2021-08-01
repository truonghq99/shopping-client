package com.service.serviceImpl;

import java.util.List;

import com.CustomStaffDetails;
import com.model.Staff;
import com.repository.StaffRepository;
import com.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService,UserDetailsService {

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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Staff staff = repo.findStaffByUsername(username);
        CustomStaffDetails userDetails=null;
		if(staff!=null) {
			userDetails = new CustomStaffDetails();
			userDetails.setStaff(staff);
		}else {
			throw new UsernameNotFoundException("Username does not exist with name: "+username);
		}
		return userDetails;
	}
 

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