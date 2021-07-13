package com.member;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController{

    @GetMapping("/")
    public String home(){
        return "index.html";
    }

    @RequestMapping(value="/signup")
    public String showRegistrationForm(Model model){
        Member member= new Member();
        model.addAttribute("member",member );
        return "signup";
    }
    
}