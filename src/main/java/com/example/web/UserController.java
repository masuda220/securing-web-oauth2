package com.example.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User principal, Model model) {
//        return Collections.singletonMap("user", principal.getAttribute("name"));
        model.addAttribute("user", principal);
        return "user";
    }
}
