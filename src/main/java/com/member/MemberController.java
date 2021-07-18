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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        if(response.equals("client")){
            System.out.println("Login successful");
            return "redirect:/home/"+member.getId();
        }else if(response.equals("admin")){
            System.out.println("Welcome admin");
            return "redirect:/home-page";
        }else{
            System.out.println("Login failed");
            return "client/login";
        }
    }
    //show home page admin
    @RequestMapping(value="/home-page")
    public String showHomeAdminPage(){
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


    /* PHAN NGUOI DUNG
    PHAN NGUOI DUNG
    PHAN NGUOI DUNG
    PHAN NGUOI DUNG
    PHAN NGUOI DUNG
    PHAN NGUOI DUNG
    PHAN NGUOI DUNG
    PHAN NGUOI DUNG
    PHAN NGUOI DUNG
    */

    //Dang ki tai khoan
    @RequestMapping(value ="/signup", method= RequestMethod.GET)
    public String showRegistrationForm2(Model model, Fullname fullname, Address address, Member member) {
        model.addAttribute("member",member);
        model.addAttribute("fullname", fullname);
        model.addAttribute("address", address);
        return "signup/signup";
    }

    //Save dang ki tai khoan
    @PostMapping(value="/saveInfo")
    public String saveInfo(Member member,Fullname fullname, Address address){
        addressService.saveAddress(address);
        fullnameService.saveFullName(fullname);
        member.setFullnameId(fullname);
        member.setAddressId(address);
        member.setPosition("client");
        service.createMember(member);
        return "index";
    }

    @RequestMapping(value="/member/{id}", method= RequestMethod.PUT)
    public void updateUserProfile(@RequestBody Member member, @PathVariable int id){
 
    }

    //show Profile
    @RequestMapping(value="user-profile/{id}")
    public String showUserProfile(Member member){
        service.findById(member.getId());
        return "redirect:/user-profile/{id}";
    }

    //show member home pageY
    @RequestMapping(value="/home/{id}")
    public String showHomePage(){
        return "client/client_home_page";
    }

}