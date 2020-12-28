package dev.milzipmoza.tecobrary.core.domain.wishbook.repository.clause;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBookStatus;

import static dev.milzipmoza.tecobrary.core.domain.wishbook.entity.QWishBook.wishBook;

public class WishBookClause {

    private WishBookStatus status;

    public WishBookClause(WishBookStatus status) {
        this.status = status;
    }

    public Predicate[] getPredicates() {
        return new Predicate[]{
                isStatusEqual()
        };
    }

    private BooleanExpression isStatusEqual() {
        if (this.status == null) {
            return null;
        }
        return wishBook.wishBookStatus.eq(this.status);
    }
}
