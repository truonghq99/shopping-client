package com.member;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repo;


    @Override
    public Member createMember(Member member){
        member= new Member();
        return repo.saveAndFlush(member);
    }

    @Override
    public List<Member> getAllMembers(){
        return (List<Member>) repo.findAll();
        
    }
}