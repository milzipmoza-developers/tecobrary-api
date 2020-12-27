package dev.milzipmoza.tecobrary.core.domain.rent.dto;

import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentDto {

    private final boolean isReturned;
    private final LocalDateTime rentDateTime;
    private final LocalDateTime returnDateTime;
    private final Long rentLibraryBookId;
    private final String rentLibraryBookTitle;
    private final String rentLibraryBookPublisher;
    private final String rentMemberNumber;
    private final String rentBookSerial;

    @Builder
    public RentDto(boolean isReturned, LocalDateTime rentDateTime, LocalDateTime returnDateTime, Long rentLibraryBookId, String rentLibraryBookTitle, String rentLibraryBookPublisher, String rentMemberNumber, String rentBookSerial) {
        this.isReturned = isReturned;
        this.rentDateTime = rentDateTime;
        this.returnDateTime = returnDateTime;
        this.rentLibraryBookId = rentLibraryBookId;
        this.rentLibraryBookTitle = rentLibraryBookTitle;
        this.rentLibraryBookPublisher = rentLibraryBookPublisher;
        this.rentMemberNumber = rentMemberNumber;
        this.rentBookSerial = rentBookSerial;
    }

    public static RentDto of(Rent rent) {
        return RentDto.builder()
                .isReturned(rent.isReturned())
                .rentDateTime(rent.getRentDateTime())
                .returnDateTime(rent.getReturnDateTime())
                .rentLibraryBookId(rent.getRentLibraryBookId())
                .rentLibraryBookTitle(rent.getRentLibraryBookTitle())
                .rentLibraryBookPublisher(rent.getRentLibraryBookPublisher())
                .rentMemberNumber(rent.getRentMemberNumber())
                .rentBookSerial(rent.getRentBookSerial())
                .build();
    }
}
