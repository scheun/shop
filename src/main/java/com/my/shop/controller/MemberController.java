package com.my.shop.controller;

import com.my.shop.model.Member;
import com.my.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/member/join")
    public String join() {
        return "member/join";
    }

    @PostMapping("/join")
    @ResponseBody
    public int joinMembers(Member member) {
        return memberService.joinMember(member);
    }

    @GetMapping("/member/login")
    public String login(@CookieValue(required = false) String id, Model model) {

        if (id != null) model.addAttribute("id", id);

        return "member/login";
    }

    @PostMapping("/member/login")
    public String loginMembers(String id, String pw, HttpServletRequest request, String rememberId, String rememberMe, HttpServletResponse response, Model model, String uuid) {
        HttpSession session = request.getSession();
        pw = passwordEncoder.encode(pw);
        Member member = memberService.login(id, pw);

        if (member != null) {
            if (session.getAttribute("id") == null) session.setAttribute("id", member.getId());
                model.addAttribute("msg", member.getId() + " 로그인 되었습니다.");

            if (rememberId != null) {
                Cookie cookie = new Cookie("id", member.getId());
                cookie.setMaxAge(5);
                response.addCookie(cookie);
            }

        } else {
            model.addAttribute("msg", "아이디와 비밀번호를 확인하세요.");
        }
        System.out.println(pw);
        return "member/welcome";
    }


    @GetMapping("/member/logout")
    public String logoutMembers(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("/member/findId")
    public String findId() {
        return "member/findId";
    }

    @RequestMapping(value="/member/findIdResult", method = {RequestMethod.POST})
    public String findIdResult(String email, Model model) {
        if(memberService.findId(email) == null) {
            model.addAttribute("msg", "해당 아이디가 없습니다.");
        } else {
            model.addAttribute("msg", "아이디는 " + memberService.findId(email) + "입니다.");
        }
        return "member/findIdResult";
    }

    @GetMapping("/member/findPw")
    public String findPw() {
        return "member/findPw";
    }

    @RequestMapping(value="/member/findPwResult", method = {RequestMethod.POST})
    public String findPwResult(String id, String email, Model model) {
        if(memberService.findPw(id, email) == null) {
            model.addAttribute("msg", "해당 비밀번호가 없습니다.");
        } else {
            model.addAttribute("msg", "비밀번호는 " + memberService.findPw(id, email) + "입니다.");
        }
        return "member/findPwResult";
    }
}
