package dev.milzipmoza.tecobrary.api.rent.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.rent.facade.RentFacade;
import dev.milzipmoza.tecobrary.api.rent.request.MemberRentRequest;
import dev.milzipmoza.tecobrary.api.rent.response.MemberRentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebRentController {

    private final RentFacade rentFacade;

    @GetMapping("/web/rents")
    public ApiResponse<MemberRentResponse> getRents(@RequestHeader("X-TECOBRARY-MEMBER-NO") String memberNumber,
                                                    MemberRentRequest request) {
        MemberRentResponse response = rentFacade.getMemberRents(memberNumber, request.getPage(), request.getSize());
        return ApiResponse.ok("회원의 대여내역을 조회하였습니다.", response);
    }
}
