package dev.milzipmoza.tecobrary.core.domain.member.dto;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MemberPageDto {

    private final int totalPages;
    private final boolean isFirstPage;
    private final boolean isLastPage;
    private final List<MemberDto> members;

    @Builder
    public MemberPageDto(int totalPages, boolean isFirstPage, boolean isLastPage, List<MemberDto> members) {
        this.totalPages = totalPages;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.members = members;
    }

    public static MemberPageDto of(Page<Member> members) {
        return MemberPageDto.builder()
                .totalPages(members.getTotalPages())
                .isFirstPage(members.isFirst())
                .isLastPage(members.isLast())
                .members(members.stream()
                        .map(MemberDto::of)
                        .collect(Collectors.toList()))
                .build();
    }
}
