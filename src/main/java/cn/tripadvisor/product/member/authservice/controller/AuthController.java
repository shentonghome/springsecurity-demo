package cn.tripadvisor.product.member.authservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author tongshen
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    @PreAuthorize("hasPermission()")
    public String login(@RequestParam String username, @RequestParam String password) {
        return username+password;
    }
}