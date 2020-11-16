package cn.tripadvisor.product.member.authservice.service;

import cn.tripadvisor.product.member.authservice.bean.User;
import cn.tripadvisor.product.member.authservice.dto.JwtUser;
import cn.tripadvisor.product.member.authservice.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Qualifier("jwtUserDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    public User register(User userToAdd) {

        //TODO 注册
//        final String username = userToAdd.getUserName();
//        if (userDao.selectByUserName(username) != null) {
//            return null;
//        }
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        final String rawPassword = userToAdd.getPassword();
//        userToAdd.setPassword(encoder.encode(rawPassword));
//        userToAdd.setLastPasswordResetDate(new Date());
//        userToAdd.setRoles(asList("ROLE_USER"));
//        return userDao.insert(userToAdd);
        return null;
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        //验证用户和用户密码
        final Authentication authentication = authenticationManager.authenticate(upToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}