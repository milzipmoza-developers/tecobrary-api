package dev.milzipmoza.tecobrary.core.domain.member.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    @DisplayName("회원의 권한 정보를 수정한다.")
    void updateMemberAuthority() {
        Member member = Member.builder()
                .authService(new MemberAuthService("auth-key", MemberAuthProvider.GITHUB))
                .build();

        member.updateAuthority(MemberAuthority.AUTHORIZED);

        assertThat(member.getAuthority()).isEqualTo(MemberAuthority.AUTHORIZED);
    }
}