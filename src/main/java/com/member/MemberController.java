package com.member;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;

import com.address.Address;
import com.address.AddressService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullname.Fullname;
import com.fullname.FullnameService;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
    @Autowired
    private MemberService service;
    @Autowired
    private AddressService addressService;
    @Autowired
    private FullnameService fullnameService;

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
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
        model.addAttribute("fullname", fullname);
        model.addAttribute("address", address);
        return "signup";
    }

    @PostMapping(value = "/saveMember")
    public String saveMember(@Validated Member member, Fullname fullname, Address address) {
        addressService.saveAddress(address);
        fullnameService.saveFullName(fullname);
        service.createMember(member);
        return "/";
    }

    // Show list member
    @RequestMapping(value = "/list_members")
    public String showListMembers(Model model, Member member) {
        model.addAttribute("members", service.getAllMembers());

        return "admin/list_members";
    }

}