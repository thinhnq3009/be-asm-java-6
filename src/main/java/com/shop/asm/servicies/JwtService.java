package com.shop.asm.servicies;

import com.shop.asm.auth.Role;
import com.shop.asm.dto.UserDto;
import com.shop.asm.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {

    private static final String SECRET_KEY = "8A7D6F43A9C2B5E8164F301B89D7E520A431BEDB263EBC0B6C8E9775DB741FC9";
    private static final int TOKEN_DAY_LIVE = 1;


    private Key getSignInkey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public UserDto extractUserDto(String token) {
        Claims claims = extractAllClaims(token);
        UserDto userDto = new UserDto();
        userDto.setRole(Role.valueOf((String) claims.get("role")));
        userDto.setFullname((String) claims.get("fullname"));
        userDto.setPhone((String) claims.get("phone"));
        userDto.setEmail((String) claims.get("email"));
        return userDto;

    }

    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {

        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * TOKEN_DAY_LIVE))
                .signWith(getSignInkey())
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
        User user = (User) userDetails;
        Map<String, Object> map = new HashMap<>();
        copyUserToMap(user, map);

        return generateToken(map, userDetails);
    }

    private static void copyUserToMap(User user, Map<String, Object> map) {
        map.put("role", user.getRole());
        map.put("fullname", user.getFullname());
        map.put("phone", user.getPhone());
        map.put("email", user.getEmail());
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(extractAllClaims(token));
    }

    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isExpired(token);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return validateToken(token, userDetails.getUsername());
    }


    public boolean isExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


}
