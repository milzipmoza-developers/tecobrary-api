package dev.milzipmoza.tecobrary.core.domain.member.repository;

import com.querydsl.jpa.JPQLQueryFactory;
import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static dev.milzipmoza.tecobrary.core.domain.member.entity.QMember.member;

public class MemberCustomRepositoryImpl extends QuerydslRepositorySupport implements MemberCustomRepository {

    private final JPQLQueryFactory queryFactory;

    public MemberCustomRepositoryImpl(JPQLQueryFactory queryFactory) {
        super(Member.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Member> findAllByName(String nickName) {
        return from(member)
                .where(member.nickName.contains(nickName))
                .fetchAll()
                .fetch();
    }
}
