package com.member;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repo;


    @Override
    public Member createMember(Member member){
        member= new Member();
        return repo.save(member);
    }
}