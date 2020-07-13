package com.example.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtils {
    public static final String TOKEN_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    // 密钥/加盐
    private static final String SECRET = "iCode";
    // jwt 的签发者
    private static final String ISS = "guangmingdexin";
    // token过期的时间是3600秒
    private static final long EXPIRATION = 3600L;

    // 选择了记住我之后的过期时间为7天
    //private static final long EXPIRATION_REMEMBER = 604800L;

    // 创建token
    public static String createToken(String username) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();

    }

    // 从token中获取用户名
    public static String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    // 是否过期
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    // 解析token
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
