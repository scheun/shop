package com.my.shop.service;

import com.my.shop.dao.map.MemberMap;
import com.my.shop.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMap memberMap;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int joinMember(Member member) {
        String encodedPassword = passwordEncoder.encode(member.getPw());
        member.setPw(encodedPassword);
        return memberMap.joinMember(member);
    }

    @Override
    public Member login(String id, String pw) {
        return memberMap.login(id, pw);
    }

    @Override
    public String findId(String email) {
        return memberMap.findId(email);
    }

    @Override
    public String findPw(String id, String email) {
        return memberMap.findPw(id, email);
    }
}
