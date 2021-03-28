package dev.milzipmoza.tecobrary.core.domain.member.util;

import org.junit.jupiter.api.Test;

class MemberNumberGeneratorTest {

    private final MemberNumberGenerator memberNumberGenerator = new MemberNumberGenerator();

    @Test
    void name() {
        System.out.println(memberNumberGenerator.generate());
    }
}