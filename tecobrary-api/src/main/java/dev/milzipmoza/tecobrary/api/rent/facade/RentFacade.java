package dev.milzipmoza.tecobrary.api.rent.facade;

import dev.milzipmoza.tecobrary.api.rent.response.MemberRentResponse;
import dev.milzipmoza.tecobrary.core.domain.rent.dto.RentPageDto;
import dev.milzipmoza.tecobrary.core.domain.rent.service.RentQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentFacade {

    private final RentQueryService rentQueryService;

    public MemberRentResponse getMemberRents(String memberNumber, int page, int size) {
        RentPageDto rentPage = rentQueryService.getMemberRents(memberNumber, page, size);
        return MemberRentResponse.of(rentPage);
    }
}
