package dev.milzipmoza.tecobrary.core.domain.member.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Column
    private String number;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String profileImageUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberAuthority authority;

    @AttributeOverrides({
            @AttributeOverride(name = "key", column = @Column(name = "auth_service_key", nullable = false)),
            @AttributeOverride(name = "provider", column = @Column(name = "auth_service_provider", nullable = false))
    })
    private MemberAuthDetail authDetail;

    @Builder
    private Member(String number, String name, String email, String profileImageUrl, MemberAuthDetail authDetail) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.authority = MemberAuthority.UNAUTHORIZED;
        this.authDetail = authDetail;
    }

    public void updateAuthority(MemberAuthority authority) {
        this.authority = authority;
    }
}
