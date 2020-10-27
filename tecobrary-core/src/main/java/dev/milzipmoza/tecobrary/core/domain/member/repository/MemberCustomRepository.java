package dev.milzipmoza.tecobrary.core.domain.member.repository;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;

import java.util.List;

public interface MemberCustomRepository {

    List<Member> findAllByName(String name);
}
