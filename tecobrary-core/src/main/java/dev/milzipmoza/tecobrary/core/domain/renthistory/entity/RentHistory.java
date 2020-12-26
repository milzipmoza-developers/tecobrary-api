package dev.milzipmoza.tecobrary.core.domain.renthistory.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class RentHistory extends BaseTimeEntity {

    @Column(nullable = false)
    private boolean isReturned;

    @Column(nullable = false)
    private LocalDateTime rentDateTime;

    @Column
    private LocalDateTime returnDateTime;

    @Column(nullable = false)
    private String rentMemberNumber;

    @Column(nullable = false)
    private String rentBookSerial;

    public RentHistory(String rentMemberNumber, String rentBookSerial) {
        this.rentBookSerial = rentBookSerial;
        this.rentMemberNumber = rentMemberNumber;
        this.isReturned = false;
        this.rentDateTime = LocalDateTime.now();
    }
}
