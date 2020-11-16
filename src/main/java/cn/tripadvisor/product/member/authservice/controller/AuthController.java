package cn.tripadvisor.product.member.authservice.controller;

import cn.tripadvisor.product.member.authservice.bean.User;
import cn.tripadvisor.product.member.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> createAuthenticationToken(@RequestParam String userName, @RequestParam String password) {
        final String token = authService.login(userName, password);

        // Return the token
        return ResponseEntity.ok(token);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<String> refreshAndGetAuthenticationToken(
            HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(refreshedToken);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User addedUser) {
        return authService.register(addedUser);
    }
}