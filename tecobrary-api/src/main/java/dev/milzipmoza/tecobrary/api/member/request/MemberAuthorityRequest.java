package dev.milzipmoza.tecobrary.api.member.request;

import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Getter;

@Getter
public class MemberAuthorityRequest {

    private final MemberAuthority authority;

    public MemberAuthorityRequest(MemberAuthority authority) {
        this.authority = authority;
    }
}
