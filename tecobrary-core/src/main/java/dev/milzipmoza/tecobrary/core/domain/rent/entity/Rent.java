package dev.milzipmoza.tecobrary.core.domain.rent.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Rent extends BaseTimeEntity {

    @Column(nullable = false)
    private boolean isReturned;

    @Column(nullable = false)
    private LocalDateTime rentDateTime;

    @Column
    private LocalDateTime returnDateTime;

    @Column(nullable = false)
    private Long rentLibraryBookId;

    @Column(nullable = false)
    private String rentLibraryBookTitle;

    @Column(nullable = false)
    private String rentLibraryBookPublisher;

    @Column(nullable = false)
    private String rentMemberNumber;

    @Column(nullable = false)
    private String rentBookSerial;

    @Builder
    private Rent(Long rentLibraryBookId, String rentLibraryBookTitle, String rentLibraryBookPublisher, String rentMemberNumber, String rentBookSerial) {
        this.rentLibraryBookId = rentLibraryBookId;
        this.rentLibraryBookTitle = rentLibraryBookTitle;
        this.rentLibraryBookPublisher = rentLibraryBookPublisher;
        this.rentBookSerial = rentBookSerial;
        this.rentMemberNumber = rentMemberNumber;
        doRent();
    }

    public static Rent doRent(Long rentLibraryBookId, String rentLibraryBookTitle, String rentLibraryBookPublisher, String rentMemberNumber, String rentBookSerial) {
        return Rent.builder()
                .rentLibraryBookId(rentLibraryBookId)
                .rentLibraryBookTitle(rentLibraryBookTitle)
                .rentLibraryBookPublisher(rentLibraryBookPublisher)
                .rentBookSerial(rentBookSerial)
                .rentMemberNumber(rentMemberNumber)
                .build();
    }

    public void doReturn() {
        this.isReturned = true;
        this.returnDateTime = LocalDateTime.now();
    }

    private void doRent() {
        this.isReturned = false;
        this.rentDateTime = LocalDateTime.now();
    }
}
