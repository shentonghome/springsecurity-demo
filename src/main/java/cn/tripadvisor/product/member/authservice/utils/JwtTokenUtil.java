//package cn.tripadvisor.product.member.authservice.utils;
//
//import cn.tripadvisor.product.member.authservice.dto.JwtUser;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.Getter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author tongshen
// */
//@Component
//public class JwtTokenUtil implements Serializable {
//    private String secret;
//    private Long expiration;
//    @Getter
//    private String header="Author";
//
//    private String generateToken(Map<String, Object> claims) {
//        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
//        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
//    }
//
//    private Claims getClaimsFromToken(String token) {
//        Claims claims;
//        try {
//            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//
//        } catch (Exception e) {
//            claims = null;
//        }
//        return claims;
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>(2);
//        claims.put("sub", userDetails.getUsername());
//        claims.put("created", new Date());
//        return generateToken(claims);
//
//    }
//
//    public String getUsernameFromToken(String token) {
//        String username;
//        try {
//            Claims claims = getClaimsFromToken(token);
//            username = claims.getSubject();
//
//        } catch (Exception e) {
//            username = null;
//
//        }
//        return username;
//
//    }
//
//    public Boolean isTokenExpired(String token) {
//        try {
//            Claims claims = getClaimsFromToken(token);
//            Date expiration = claims.getExpiration();
//            return expiration.before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public String refreshToken(String token) {
//        String refreshedToken;
//        try {
//            Claims claims = getClaimsFromToken(token);
//            claims.put("created", new Date());
//            refreshedToken = generateToken(claims);
//
//        } catch (Exception e) {
//            refreshedToken = null;
//
//        }
//        return refreshedToken;
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        JwtUser user = (JwtUser) userDetails;
//        String username = getUsernameFromToken(token);
//        return (username.equals(user.getUsername()) && !isTokenExpired(token));
//
//    }
//
//}