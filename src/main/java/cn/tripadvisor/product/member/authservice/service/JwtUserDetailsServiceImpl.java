package cn.tripadvisor.product.member.authservice.service;

import cn.tripadvisor.product.member.authservice.dto.JwtUser;
import cn.tripadvisor.product.member.authservice.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tongshen
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.selectByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("'%s'.这个用户不存在", s));
        }
        List<SimpleGrantedAuthority> collect = user.getRole().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new JwtUser(user.getUserId(), user.getUserName(), user.getPassword(), user.getEmail());
    }
}
