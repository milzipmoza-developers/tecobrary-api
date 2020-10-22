package dev.milzipmoza.tecobrary.core.domain.member.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Column
    private String memberNumber;

    @Column
    private String nickName;

    @AttributeOverrides({
            @AttributeOverride(name = "key", column = @Column(name = "auth_service_key", nullable = false)),
            @AttributeOverride(name = "provider", column = @Column(name = "auth_service_provider", nullable = false))
    })
    private MemberAuthService authService;

    @Column
    private boolean authenticated;

    @Builder
    public Member(String memberNumber, String nickName, MemberAuthService authService, boolean authenticated) {
        this.memberNumber = memberNumber;
        this.nickName = nickName;
        this.authService = authService;
        this.authenticated = authenticated;
    }
}
