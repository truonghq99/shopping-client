package com.service.serviceImpl;

import javax.transaction.Transactional;

import com.model.Member;
import com.service.MemberService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    private SessionFactory sessionFactory;
 
    public Member findAccount(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Member.class, userName);
    }
}
