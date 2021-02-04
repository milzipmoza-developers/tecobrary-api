package dev.milzipmoza.tecobrary.security.jwt;

import dev.milzipmoza.tecobrary.config.properties.JwtProperties;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberInfoDto;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;

@Slf4j
public class JwtAuthenticator {

    private static final SignatureAlgorithm ALGORITHM_HS_256 = SignatureAlgorithm.HS256;
    private static final String JWT_ISSUER = "TECOBRARY-API";
    private static final String HEADER_TYPE_KEY = "typ";
    private static final String HEADER_TYPE_VALUE = "JWT";
    private static final String HEADER_ALGORITHM_KEY = "alg";
    private static final String HEADER_ALGORITHM_REG_DATE_KEY = "regDate";
    private static final String CLAIMS_NUMBER = "number";
    private static final String CLAIMS_EMAIL = "email";
    private static final String CLAIMS_NAME = "name";
    private static final String CLAIMS_ROLE = "role";

    @Autowired
    private JwtProperties jwtProperties;

    public String generateToken(MemberInfoDto member) {
        return Jwts.builder()
                .setIssuer(JWT_ISSUER)
                .setSubject(member.getNumber())
                .setHeader(createHeader())
                .setClaims(createClaims(member))
                .setExpiration(createExpireDate())
                .signWith(ALGORITHM_HS_256, createSigningKey())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

    public String getMemberNumber(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
        return claims.get("number", String.class);
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> headers = new HashMap<>();
        headers.put(HEADER_TYPE_KEY, HEADER_TYPE_VALUE);
        headers.put(HEADER_ALGORITHM_KEY, ALGORITHM_HS_256.getValue());
        headers.put(HEADER_ALGORITHM_REG_DATE_KEY, System.currentTimeMillis());
        return headers;
    }

    private Map<String, Object> createClaims(MemberInfoDto member) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIMS_NUMBER, member.getNumber());
        claims.put(CLAIMS_EMAIL, member.getEmail());
        claims.put(CLAIMS_NAME, member.getName());
        claims.put(CLAIMS_ROLE, member.getAuthority().getSecurityRoleName());
        return claims;
    }

    private Date createExpireDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        return calendar.getTime();
    }

    private Key createSigningKey() {
        return new SecretKeySpec(Base64.getDecoder().decode(jwtProperties.getSecretKey()), SignatureAlgorithm.HS256.getJcaName());
    }
}
