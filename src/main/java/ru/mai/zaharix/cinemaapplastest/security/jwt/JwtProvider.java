package ru.mai.zaharix.cinemaapplastest.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.mai.zaharix.cinemaapplastest.security.core.CustomerDetails;

import java.time.Instant;
import java.util.Date;

@Component
@Log
public class JwtProvider {
    @Value("${zaharix.app.jwtSecret}")
    private String jwtSecret;

    @Value("${zaharix.app.jwtExpirationMs}")
    private String jwtExpirationMs;

    public String generateToken(Authentication authentication) {

        CustomerDetails customerDetails = (CustomerDetails)authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(customerDetails.getUsername())
                .setExpiration(new Date())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.severe("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            log.severe("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            log.severe("Malformed jwt");
        } catch (SignatureException sEx) {
            log.severe("Invalid signature");
        } catch (Exception e) {
            log.severe("invalid token");
        }
        return false;
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
