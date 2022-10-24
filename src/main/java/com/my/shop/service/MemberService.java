package com.my.shop.service;

import com.my.shop.model.Member;

public interface MemberService {
    int joinMember(Member member);
    Member login(String id, String pw);
    String findId(String email);
    String findPw(String id, String email);
}
