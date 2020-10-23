package dev.milzipmoza.tecobrary.core.domain.rent.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class RentHistory extends BaseTimeEntity {

    @Column(nullable = false)
    private boolean returned;

    @Column(nullable = false)
    private LocalDateTime rentDateTime;

    @Column
    private LocalDateTime returnDateTime;

    @Column(nullable = false)
    private Long rentBookId;

    @Column(nullable = false)
    private Long rentMemberId;

    @Column(nullable = false)
    private LocalDateTime txDateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_id")
    private Rent rent;

    @Builder
    private RentHistory(boolean returned, LocalDateTime rentDateTime, LocalDateTime returnDateTime, Long rentBookId, Long rentMemberId, LocalDateTime txDateTime, Rent rent) {
        this.returned = returned;
        this.rentDateTime = rentDateTime;
        this.returnDateTime = returnDateTime;
        this.rentBookId = rentBookId;
        this.rentMemberId = rentMemberId;
        this.txDateTime = txDateTime;
        this.rent = rent;
    }
}
