package dev.milzipmoza.tecobrary.api.member.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.member.facade.MemberFacade;
import dev.milzipmoza.tecobrary.api.member.request.MemberAuthorityRequest;
import dev.milzipmoza.tecobrary.api.member.request.MemberPageRequest;
import dev.milzipmoza.tecobrary.api.member.response.MemberDetailResponse;
import dev.milzipmoza.tecobrary.api.member.response.MemberPageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdminMemberController {

    private final MemberFacade memberFacade;

    @GetMapping("/admin/members")
    public ApiResponse<MemberPageResponse> get(MemberPageRequest request) {
        MemberPageResponse response = memberFacade.getMembers(request.getPage(), request.getSize());
        return ApiResponse.ok("회원 목록을 조회하였습니다.", response);
    }

    @GetMapping("/admin/members/{id}")
    private ApiResponse<MemberDetailResponse> getDetail(@PathVariable Long id) {
        MemberDetailResponse response = memberFacade.getMember(id);
        return ApiResponse.ok("회원 상세 정보를 조회하였습니다.", response);
    }

    @PostMapping("/admin/members/{id}")
    private ApiResponse<MemberDetailResponse> updateAuthority(@PathVariable Long id,
                                                              @RequestBody MemberAuthorityRequest body) {
        MemberDetailResponse response = memberFacade.updateAuthority(id, body.getAuthority());
        return ApiResponse.ok("회원 권한을 업데이트 하였습니다.", response);
    }
}
