package dev.milzipmoza.tecobrary.core.domain.member.service;

import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberDetailDto;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberSimpleInfoDto;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberUpsertDto;
import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthDetail;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthProvider;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import dev.milzipmoza.tecobrary.core.domain.member.repository.MemberRepository;
import dev.milzipmoza.tecobrary.core.domain.member.util.MemberNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MemberCommandService {

    private final MemberRepository memberRepository;
    private final MemberNumberGenerator memberNumberGenerator;

    public MemberSimpleInfoDto upsert(MemberUpsertDto memberDto) {
        MemberAuthProvider provider = MemberAuthProvider.of(memberDto.getProvider());
        Member member = memberRepository.findByAuthDetailProviderAndAuthDetailKey(provider, memberDto.getProviderKey())
                .orElse(Member.builder()
                        .name(memberDto.getName())
                        .email(memberDto.getEmail())
                        .profileImageUrl(memberDto.getProfileImageUrl())
                        .authDetail(new MemberAuthDetail(memberDto.getProviderKey(), provider))
                        .number(memberNumberGenerator.generate()) // todo: 중복 처리
                        .build());

        return MemberSimpleInfoDto.of(memberRepository.save(member));
    }

    public MemberDetailDto updateAuthority(Long id, MemberAuthority authority) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));
        member.updateAuthority(authority);

        return MemberDetailDto.of(memberRepository.save(member));
    }
}
