package com.example.api;

import com.example.application.SecurityInfoQueryService;
import com.example.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    SecurityInfoQueryService queryService;

    public UserController(SecurityInfoQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/user")
    public Map<String, String> user(
//            @AuthenticationPrincipal OAuth2User principal
    ) {
        String queried = queryService.userNameFromSecurityContext();
        User user = new User(queried);
        return user.toMap();
    }
}
