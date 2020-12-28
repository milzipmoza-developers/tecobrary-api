package dev.milzipmoza.tecobrary.core.domain.wishbook.entity;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
public enum WishBookStatus {
    REQUESTED("신청됨"),
    CONFIRMED("처리중"),
    COMPLETED("처리완료"),
    HELD("보류됨");

    private static final List<WishBookStatus> REQUESTED_CHANGEABLE_TO = Arrays.asList(CONFIRMED, COMPLETED, HELD);
    private static final List<WishBookStatus> CONFIRMED_CHANGEABLE_TO = Collections.singletonList(COMPLETED);


    private final String displayName;

    WishBookStatus(String displayName) {
        this.displayName = displayName;
    }


    public boolean changeableTo(WishBookStatus updatedStatus) {
        if (this == REQUESTED) {
            return REQUESTED_CHANGEABLE_TO.contains(updatedStatus);
        }
        if (this == CONFIRMED) {
            return CONFIRMED_CHANGEABLE_TO.contains(updatedStatus);
        }
        return false;
    }
}
