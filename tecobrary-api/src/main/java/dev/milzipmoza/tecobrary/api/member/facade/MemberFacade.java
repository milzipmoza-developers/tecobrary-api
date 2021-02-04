package dev.milzipmoza.tecobrary.api.member.facade;

import dev.milzipmoza.tecobrary.api.member.response.MemberDetailResponse;
import dev.milzipmoza.tecobrary.api.member.response.MemberPageResponse;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberDetailDto;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberPageDto;
import dev.milzipmoza.tecobrary.core.domain.member.service.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberFacade {

    private final MemberQueryService memberQueryService;

    public MemberPageResponse getMembers(int page, int size) {
        MemberPageDto members = memberQueryService.getMembers(page, size);
        return MemberPageResponse.builder()
                .totalPages(members.getTotalPages())
                .isFirstPage(members.isFirstPage())
                .isLastPage(members.isLastPage())
                .page(page)
                .size(size)
                .members(members.getMembers())
                .build();
    }

    public MemberDetailResponse getMember(Long id) {
        MemberDetailDto member = memberQueryService.getMember(id);
        return MemberDetailResponse.of(member);
    }
}
