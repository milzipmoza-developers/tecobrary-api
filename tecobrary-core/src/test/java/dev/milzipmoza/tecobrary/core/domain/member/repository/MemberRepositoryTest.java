package dev.milzipmoza.tecobrary.core.domain.member.repository;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthProvider;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager em;

    @Test
    void save() {

        Member member = Member.builder()
                .memberNumber("memberNumber")
                .nickName("luffy")
                .authService(new MemberAuthService("12346578", MemberAuthProvider.GITHUB))
                .authenticated(false)
                .build();

        Member savedMember = memberRepository.saveAndFlush(member);

        Long id = savedMember.getId();

        em.clear();

        Member foundMember = memberRepository.findById(id).get();

        assertThat(foundMember.getId()).isEqualTo(id);
        assertThat(foundMember.getCreatedAt()).isNotNull();
        assertThat(foundMember.getModifiedAt()).isNotNull();
    }
}