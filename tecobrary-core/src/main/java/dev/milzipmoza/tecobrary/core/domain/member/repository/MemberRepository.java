package dev.milzipmoza.tecobrary.core.domain.member.repository;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberCustomRepository {
}
