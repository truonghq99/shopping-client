package com.member;



import java.util.List;


public interface MemberService {

    Member createMember(Member member);

    List<Member> getAllMembers();


    String checkLogin(String username,String password);
}
