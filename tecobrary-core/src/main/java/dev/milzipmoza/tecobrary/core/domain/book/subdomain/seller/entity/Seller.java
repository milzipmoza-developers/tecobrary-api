package dev.milzipmoza.tecobrary.core.domain.book.subdomain.seller.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller extends BaseTimeEntity {

    @Column
    private String name;

    @Column
    private String link;

    @Column
    private String price;

    @Builder
    public Seller(String name, String link, String price) {
        this.name = name;
        this.link = link;
        this.price = price;
    }
}
