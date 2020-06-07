package org.talentboost.networkforgiving.utils;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.talentboost.networkforgiving.model.User;

import javax.crypto.SecretKey;

@Component
public class JwtTokenUtil implements Serializable {
    public static final long JWT_TOKEN_VALIDITY = 10 * 60 * 60; //the token is valid for 10 hours

    @Value("${jwt.secret}")
    private String secret;

    // Get the expiration date from the jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // Get resolved claims from the jwt token
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // Retrieve claims - key: header, body, signature
    private Claims getAllClaimsFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    // Check if the token has expired - exp date
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // Generate token for user
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        return doGenerateToken(claims, Integer.toString(user.getId()));
    }

    // While creating the token -
    //      1. Define  claims - exp, iat, sub
    //      2. Sign the JWT using the HS256 algorithm and secret key.
    //      3. According to JWS Compact Serialization: compaction of the JWT to a URL-safe string
    //              The JWS Compact Serialization represents digitally signed or MACed
    //              content as a compact, URL-safe string.  This string is:
    //
    //                      BASE64URL(UTF8(JWS Protected Header)) || '.' ||
    //                      BASE64URL(JWS Payload) || '.' ||
    //                      BASE64URL(JWS Signature)

    private String doGenerateToken(Map<String, Object> claims, String userId) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().setClaims(claims).setSubject(userId).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(key, SignatureAlgorithm.HS256).compact();
    }

    // Validate token by exp date
    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}
