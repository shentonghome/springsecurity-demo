package cn.tripadvisor.product.member.authservice.dto;

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
    String userName;
    String password;
    List<String> role;
    private Integer state;
}
