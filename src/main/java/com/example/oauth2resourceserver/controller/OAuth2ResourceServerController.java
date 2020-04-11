package com.example.oauth2resourceserver.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2ResourceServerController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Index, %s!", jwt.getSubject());
    }

    @GetMapping("/access/read")
    public String readyAccess() {
        return "Read access";
    }

    @PostMapping("/access/write")
    public String writeAccess(@RequestBody String text) {
        return String.format("Write access. Text: %s", text);
    }

    @GetMapping("/access/free")
    public String freeAccess() {
        return "Free access. No authentication needed";
    }
}
