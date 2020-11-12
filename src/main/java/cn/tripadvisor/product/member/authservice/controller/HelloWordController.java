package cn.tripadvisor.product.member.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tongshen
 * @date 2020/11/3
 */
@RestController
public class HelloWordController {
    @GetMapping("/hello")
    public String hello() {
        return"hello";
    }
}
