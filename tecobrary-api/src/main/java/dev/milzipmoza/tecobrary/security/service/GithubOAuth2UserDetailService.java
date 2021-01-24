package dev.milzipmoza.tecobrary.security.service;

import dev.milzipmoza.tecobrary.core.client.github.GithubApiClient;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberDto;
import dev.milzipmoza.tecobrary.core.domain.member.service.MemberCommandService;
import dev.milzipmoza.tecobrary.security.dto.OAuth2AttributeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;
import java.util.Optional;

/**
 * github oauth2 login user info endpoint service
 *
 * @see GithubOAuth2User
 */
@Slf4j
public class GithubOAuth2UserDetailService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    private GithubApiClient githubApiClient;

    @Autowired
    private MemberCommandService memberCommandService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("[OAuth2User] login request={}", userRequest);
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email = Optional.ofNullable((String) attributes.get("email"))
                .orElse(githubApiClient.getPrimaryEmail(userRequest.getAccessToken().getTokenValue()));

        OAuth2AttributeDto oAuth2Attribute = OAuth2AttributeDto.of(clientRegistration, attributes, email);

        MemberDto member = memberCommandService.upsert(oAuth2Attribute.toMemberDto());

        return GithubOAuth2User.builder()
                .memberAuthority(member.getAuthority())
                .attributes(oAuth2Attribute.getAttributes())
                .build();
    }
}
