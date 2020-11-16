package cn.tripadvisor.product.member.authservice.service;

import cn.tripadvisor.product.member.authservice.bean.User;

public interface AuthService {
    User register(User userToAdd);

    String login(String username, String password);

    String refresh(String oldToken);
}