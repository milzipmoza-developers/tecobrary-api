package dev.milzipmoza.tecobrary.core.domain.member.repository;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberCustomRepository {

    Optional<Member> findByAuthDetailProviderAndAuthDetailKey(MemberAuthProvider provider, String key);

    Optional<Member> findByAuthDetailKey(String key);

    Optional<Member> findByNumber(String memberNumber);
}
