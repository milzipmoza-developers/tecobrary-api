package dev.milzipmoza.tecobrary.core.domain.member.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class MemberNumberGenerator {

    public String generate() {
        long currentTime = System.currentTimeMillis();
        String memberNumber = RandomStringUtils.randomAlphanumeric(5) +
                Long.toHexString(currentTime);
        return memberNumber.toUpperCase();
    }
}
