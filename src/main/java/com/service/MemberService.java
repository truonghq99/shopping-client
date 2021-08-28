
package com.service;

import com.model.Member;


import org.springframework.stereotype.Service;

@Service
public interface MemberService {
 
    public Member findAccount(String userName);
}