package dev.milzipmoza.tecobrary.core.domain.rent.dto;

import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Getter
public class RentPageDto {

    private final int totalPages;
    private final boolean isFirstPage;
    private final boolean isLastPage;
    private final List<RentDto> rents;

    @Builder
    public RentPageDto(int totalPages, boolean isFirstPage, boolean isLastPage, List<RentDto> rents) {
        this.totalPages = totalPages;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.rents = rents;
    }

    public static RentPageDto of(PageImpl<Rent> pageRents) {
        return RentPageDto.builder()
                .totalPages(pageRents.getTotalPages())
                .isFirstPage(pageRents.isFirst())
                .isLastPage(pageRents.isLast())
                .build();
    }
}
