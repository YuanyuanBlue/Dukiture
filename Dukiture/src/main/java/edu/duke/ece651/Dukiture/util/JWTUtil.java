package edu.duke.ece651.Dukiture.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

@Component
public class JWTUtil implements Serializable {
    public String getUsernamefromToken(String tokenString) {
        Claims currClaims =  Jwts.parser().setSigningKey(JWTConstants.SIGN_KEY).parseClaimsJws(tokenString).getBody();
        return currClaims.getSubject();
    }
    public Date getExpirationTimeFromToken(String tokenString) {
        Claims currClaims =  Jwts.parser().setSigningKey(JWTConstants.SIGN_KEY).parseClaimsJws(tokenString).getBody();
        return currClaims.getExpiration();
    }
    public String generateToken(String username) {
        Claims currClaims = Jwts.claims().setSubject(username);
        currClaims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        return Jwts.builder().setClaims(currClaims).setIssuer("dukiture")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWTConstants.TOKEN_VALIDITY_TIME * 1000))
                .signWith(SignatureAlgorithm.HS256, JWTConstants.SIGN_KEY)
                .compact();
    }
    public boolean isExpired(String tokenString) {
        Date expireDate = getExpirationTimeFromToken(tokenString);
        return expireDate.before(new Date());
    }
    public boolean isValid(String tokenString, UserDetails userDetails) {
        String username = getUsernamefromToken(tokenString);
        return username.compareTo(userDetails.getUsername()) == 0 && !isExpired(tokenString);
    }
}
