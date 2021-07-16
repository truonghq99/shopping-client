package com.member;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import java.text.SimpleDateFormat;

import java.util.Date;

import com.address.Address;
import com.address.AddressService;
import com.fullname.Fullname;
import com.fullname.FullnameService;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
    @Autowired
    private MemberService service;
    @Autowired
    private FullnameService fullnameService;
    @Autowired
    private AddressService addressService;
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
  
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    }

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Member member = new Member();
        Fullname fullname = new Fullname();
        Address address = new Address();
        model.addAttribute("member", member);
        model.addAttribute("address", address);
        model.addAttribute("fullname", fullname);
        return "createUser";
    }
    @PostMapping(value="/saveFullName")
    public void saveFullName(@Validated Fullname fullname){
        fullnameService.saveFullName(fullname);
    }
    @PostMapping(value="/saveAddress")
    public void saveAddress(@Validated Address address){
        addressService.saveAddress(address);
    }
    
    @PostMapping(value = "/saveMember")
    public String saveMember(Member member) {
        service.createMember(member);
        System.out.println("id:"+member.getId());
        System.out.println("username:"+member.getUsername());
        System.out.println("dob:"+member.getDateOfBirth());
        System.out.println("pass:"+member.getPassword());
        System.out.println("email:"+member.getEmail());
        System.out.println("phone:"+member.getPhoneNumber());
        return "index";      
    }

    // Show list member
    @RequestMapping(value = "/list_members")
    public String showListMembers(Model model, Member member) {
        model.addAttribute("members", service.getAllMembers());
        return "admin/list_members";
    }

}