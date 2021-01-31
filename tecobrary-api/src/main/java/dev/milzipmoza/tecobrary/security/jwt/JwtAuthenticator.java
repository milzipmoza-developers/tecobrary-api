package dev.milzipmoza.tecobrary.security.jwt;

import dev.milzipmoza.tecobrary.config.properties.JwtProperties;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
    private static final String CLAIMS_EMAIL = "email";
    private static final String CLAIMS_NAME = "name";
    private static final String CLAIMS_ROLE = "role";
    private static final int ONE_WEEK = 7 * 24 * 60 * 60;

    @Autowired
    private JwtProperties jwtProperties;

    public String generateToken(MemberDto member) {
        return Jwts.builder()
                .setIssuer(JWT_ISSUER)
                .setSubject(member.getNumber())
                .setHeader(createHeader())
                .setClaims(createClaims(member))
                .setExpiration(createExpireDate())
                .signWith(ALGORITHM_HS_256, createSigningKey())
                .compact();
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> headers = new HashMap<>();
        headers.put(HEADER_TYPE_KEY, HEADER_TYPE_VALUE);
        headers.put(HEADER_ALGORITHM_KEY, ALGORITHM_HS_256.getValue());
        headers.put(HEADER_ALGORITHM_REG_DATE_KEY, System.currentTimeMillis());
        return headers;
    }

    private Map<String, Object> createClaims(MemberDto member) {
        Map<String, Object> claims = new HashMap<>();
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
