package dev.milzipmoza.tecobrary.security.jwt;

import dev.milzipmoza.tecobrary.config.properties.JwtProperties;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Slf4j
public class JwtAuthenticator {

    private static final SignatureAlgorithm ALGORITHM_HS_256 = SignatureAlgorithm.HS256;
    private static final String HEADER_TYPE_KEY = "typ";
    private static final String HEADER_ALGORITHM_KEY = "alg";
    private static final String HEADER_ALGORITHM_REG_DATE_KEY = "regDate";
    private static final String CLAIMS_EMAIL = "email";
    private static final String CLAIMS_NAME = "name";
    private static final String CLAIMS_ROLE = "role";

    @Autowired
    private JwtProperties jwtProperties;

    public String generateToken(MemberDto member) {
        return Jwts.builder()
                .setSubject("") // todo: set subject
                .setHeader(createHeader())
                .setClaims(createClaims(member))
                .setExpiration(createExpireDate())
                .signWith(ALGORITHM_HS_256, createSigningKey())
                .compact();
    }

    private Map<String, Object> createHeader() {
        return Map.of(
                HEADER_TYPE_KEY, "JWT",
                HEADER_ALGORITHM_KEY, ALGORITHM_HS_256.getValue(),
                HEADER_ALGORITHM_REG_DATE_KEY, System.currentTimeMillis()
        );
    }

    private Map<String, Object> createClaims(MemberDto member) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        return Map.of(
                CLAIMS_EMAIL, member.getEmail(),
                CLAIMS_NAME, member.getName(),
                CLAIMS_ROLE, member.getAuthority().getSecurityRoleName(),
                "exp", calendar.getTime()
        );
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
