package dev.milzipmoza.tecobrary.core.domain.member.repository;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthDetail;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;

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
                .number("memberNumber")
                .name("luffy")
                .authDetail(new MemberAuthDetail("12346578", MemberAuthProvider.GITHUB))
                .build();

        Member savedMember = memberRepository.saveAndFlush(member);

        Long id = savedMember.getId();

        em.clear();

        Member foundMember = memberRepository.findById(id).get();

        assertThat(foundMember.getId()).isEqualTo(id);
        assertThat(foundMember.getCreatedAt()).isNotNull();
        assertThat(foundMember.getModifiedAt()).isNotNull();
    }

    @Test
    @DisplayName("이름으로 회원을 모두 찾는다")
    void findAllByName() {
        memberRepository.save(Member.builder()
                .number("memberNumber1")
                .name("luffy")
                .authDetail(new MemberAuthDetail("12346578", MemberAuthProvider.GITHUB))
                .build());

        memberRepository.save(Member.builder()
                .number("memberNumber2")
                .name("luffy")
                .authDetail(new MemberAuthDetail("1234", MemberAuthProvider.GITHUB))
                .build());

        List<Member> members = memberRepository.findAllByName("luffy");

        assertThat(members.size()).isEqualTo(2);
    }
}