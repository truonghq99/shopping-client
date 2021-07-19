package com.service.serviceImpl;

import java.util.List;

import com.model.Member;
import com.repository.MemberRepository;
import com.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repo;

    @Override
    public Member createMember(Member member) {
        return repo.saveAndFlush(member);
    }

  
    @Override
    public List<Member> getAllMembers() {
        return (List<Member>) repo.findAll();

    }

    @Override
    public String checkLogin(String username, String password) {
        Member member = new Member();
        member=repo.findMemberByUsername(username);
        if (password.equals(member.getPassword())) {
            if(member.getPosition().equalsIgnoreCase("staff")){
                return "staff";
            }else if(member.getPosition().equalsIgnoreCase("manager")){
                return "manager";
            }else if(member.getPosition().equalsIgnoreCase("admin")){
                return "admin";
            }else{
                return "client";
            }
        }else{
            return "failed";
        }
    }

    @Override
    public Member findById(int id){
        return repo.getById(id);
    }

}