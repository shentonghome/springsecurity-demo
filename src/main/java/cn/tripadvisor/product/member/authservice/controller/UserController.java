package cn.tripadvisor.product.member.authservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tongshen
 * @date 2020/11/13
 */
@RestController
@RequestMapping("/user")
@PreAuthorize("isAuthenticated()")
public class UserController {
    @GetMapping("/profile")
    public UserDetails profile() {
//        return new JwtUser();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userDetails;
    }

    public static void main(String[] args) {

    }
}
