package com.my.shop.dao.map;

import com.my.shop.model.Member;

public interface MemberMap {
    int joinMember(Member member);
    Member login(String id, String pw);
    String findId(String email);
    String findPw(String id, String email);
}
