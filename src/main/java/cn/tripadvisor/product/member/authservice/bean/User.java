package cn.tripadvisor.product.member.authservice.bean;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author tongshen
 * @date 2020/11/10
 */
@Data
@Builder
public class User {
    Integer userId;
    String userName;
    String password;
    String email;
    List<String> role;
    private Integer state;
}
