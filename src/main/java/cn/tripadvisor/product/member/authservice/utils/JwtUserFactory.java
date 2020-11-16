package cn.tripadvisor.product.member.authservice.utils;

import cn.tripadvisor.product.member.authservice.bean.User;
import cn.tripadvisor.product.member.authservice.dto.JwtUser;

public final class JwtUserFactory {

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail()
        );
    }

}