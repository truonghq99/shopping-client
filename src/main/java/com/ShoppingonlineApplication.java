package com;

import com.model.Staff;
import com.repository.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ShoppingonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingonlineApplication.class, args);
	}

	// @Autowired
    // StaffRepository repo;
    // @Autowired
    // PasswordEncoder passwordEncoder;

    // @Override
    // public void run(String[] args) throws Exception {
    //     // Khi chương trình chạy
    //     // Insert vào csdl một user.
    //     Staff staff = new Staff();
    //     staff.setUsername("administrator");
    //     staff.setPassword(passwordEncoder.encode("1234546"));
    //     repo.save(staff);
    //     System.out.println(staff);
    // }

}
