package com.member;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.address.Address;
import com.address.AddressService;
import com.fullname.Fullname;
import com.fullname.FullnameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(Model model,Member member){
        model.addAttribute("username", member.getUsername());
        model.addAttribute("password", member.getPassword());
        return "client/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String checkLogin(Member member){
        String response=service.checkLogin(member.getUsername(), member.getPassword());
        System.out.println(response);
        if(response.equals("client")){
            System.out.println("Login successful");
            return "index";
        }else if(response.equals("staff")){
            System.out.println("Welcome admin");
            return "redirect:/home-page";
        }else{
            System.out.println("Login failed");
            return "client/login";
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showRegistrationForm(Model model, Member member) {
        model.addAttribute("member", member);
        return "signup/signup";
    }
    
    //save member
    @PostMapping(value = "/redirect")
    public String saveMember(@ModelAttribute("Member") Member member, HttpSession session) {
        service.createMember(member);
        session.setAttribute("idSession", member);
        System.out.println("id:"+member.getId());
        System.out.println("username:"+member.getUsername());
        System.out.println("dob:"+member.getDateOfBirth());
        System.out.println("pass:"+member.getPassword());
        System.out.println("email:"+member.getEmail());
        System.out.println("phone:"+member.getPhoneNumber());
        System.out.println("position:"+member.getPosition());
        return "redirect:/signup-step-2";
    }

    //show home page admin
    @RequestMapping(value="/home-page")
    public String showHomePage(){
        return "admin/home_page";
    }
    @RequestMapping(value="/failed-page")
    public String showFailedPage(){
        return "base/404";
    }


    // Show list member
    @RequestMapping(value = "/list_members")
    public String showListMembers(Model model, Member member) {
        model.addAttribute("members", service.getAllMembers());
        return "admin/list_members";
    }

    @RequestMapping(value ="/signup-step-2", method= RequestMethod.GET)
    public String showRegistrationForm2(Model model){
        model.addAttribute("fullname", new Fullname());
        model.addAttribute("address", new Address());
        return "signup/signup_step2";
    }

    @PostMapping(value="/saveInfo")
    public String saveInfo(@ModelAttribute("Member") Member member,Model model,Fullname fullname, Address address){
        member.setFullname(fullname);
        member.setAddress(address);
        System.out.println(member.toString());
        fullname.setMemberId(member);
        address.setMemberId(member);
        fullnameService.saveFullName(fullname);
        System.out.println("1");
        addressService.saveAddress(address);
        System.out.println("2");
        return "index";
    }

}