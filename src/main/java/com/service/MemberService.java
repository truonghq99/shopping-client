package com.service;



import java.util.List;

import com.model.Member;


public interface MemberService {

    Member createMember(Member member);

    Member findById(int id);

    List<Member> getAllMembers();

    String checkLogin(String username,String password);
}
