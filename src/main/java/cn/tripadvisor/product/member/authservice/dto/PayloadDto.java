package cn.tripadvisor.product.member.authservice.dto;

/**
 * @author tongshen
 * @date 2020/11/4
 */
public class PayloadDto {
    /**
     * 签发人
     */
    private String iss;
    /**
     * 过期时间
     */
    private String exp;
    /**
     * 主题
     */
    private String sub;
    /**
     * 受众
     */
    private String aud;
    /**
     * 生效时间
     */
    private String nbf;
    /**
     * 签发时间
     */
    private String iat;
    /**
     * 编号
     */
    private String jti;
}
