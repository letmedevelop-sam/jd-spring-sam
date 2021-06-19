package com.cybertek.util;

import com.cybertek.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtil {

    @Value("${security.jwt.secret-key}")  //this will bring from application.yml file
    private String secret = "cybertek";

    public String generateToken(User user){

        Map<String,Object> claims = new HashMap<>();  //payload    //claims --- in spring
        claims.put("username",user.getUsername());
        claims.put("email",user.getEmail());
        return createToken(claims, user.getUsername());  // create token with this PAYLOAD
    }

    private String createToken(Map<String,Object> claims,String username){    //create  the token

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *10)) //10 hours token validity
                .signWith(SignatureAlgorithm.HS256,secret).compact();       //SIGNATURE

    }

    private Claims extractAllClaims(String token){                                   //DECODE token
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);    //Functional Interface with only one abstract method for LAMBDA
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);

    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails){        //check if user name is matching and token is not expired
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }












}
