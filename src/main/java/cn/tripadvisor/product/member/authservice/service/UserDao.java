package cn.tripadvisor.product.member.authservice.service;

import cn.tripadvisor.product.member.authservice.bean.User;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author tongshen
 * @date 2020/11/10
 */
@Service
public class UserDao {
    public User selectByUserName(String name) {
        return User.builder().userName("tongshen").password("123").role(Collections.singletonList("admin")).build();
    }
}
