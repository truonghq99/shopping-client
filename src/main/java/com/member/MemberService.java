package com.member;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    Member createMember(Member member);
}
