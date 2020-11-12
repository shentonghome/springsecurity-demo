package cn.tripadvisor.product.member.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author tongshen
 * @date 2020/11/10
 */
@Data
@AllArgsConstructor
public class Result {
    Integer code;
    String token;
}
