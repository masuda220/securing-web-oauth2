package com.example.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class SecurityInfoQueryService {
    static Logger logger = LoggerFactory.getLogger(SecurityInfoQueryService.class);

    public String userNameFromSecurityContext() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication principal = context.getAuthentication();
        showContext(context);
        return principal.getName();
    }

    void showContext(SecurityContext context) {
        logger.info(context.toString());
        Authentication principal = context.getAuthentication();
        logger.info(principal.toString());
        if (principal instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) context.getAuthentication();
            logger.info("attributes:" + token.getPrincipal().getAttributes().toString());
        }
    }
}