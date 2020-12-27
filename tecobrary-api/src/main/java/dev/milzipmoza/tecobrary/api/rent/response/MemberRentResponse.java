package dev.milzipmoza.tecobrary.api.rent.response;

import dev.milzipmoza.tecobrary.core.domain.rent.dto.RentDto;
import dev.milzipmoza.tecobrary.core.domain.rent.dto.RentPageDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MemberRentResponse {

    private int totalPages;
    private boolean isFirstPage;
    private boolean isLastPage;
    private List<RentDto> rents;

    @Builder
    public MemberRentResponse(int totalPages, boolean isFirstPage, boolean isLastPage, List<RentDto> rents) {
        this.totalPages = totalPages;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.rents = rents;
    }

    public static MemberRentResponse of(RentPageDto rentPage) {
        return MemberRentResponse.builder()
                .totalPages(rentPage.getTotalPages())
                .isFirstPage(rentPage.isFirstPage())
                .isLastPage(rentPage.isLastPage())
                .rents(rentPage.getRents())
                .build();
    }
}
